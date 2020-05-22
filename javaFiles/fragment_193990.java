public void sendNotificationPingToUsers(
        @Named("userIds") List<Long> userIds,
        ZeppaNotification notification) {

    Sender sender = new Sender(Constants.SENDER_ID);

    PersistenceManager mgr = getPersistenceManager();

    try {
        List<String> allDevices = new ArrayList<String>();

        for (int i = 0; i < userIds.size(); i++) {
            long userId = userIds.get(i);

            ZeppaUser zeppaUser = mgr
                    .getObjectById(ZeppaUser.class, userId);

            if (zeppaUser != null) {
                ZeppaNotification specificNotification = new ZeppaNotification();
                specificNotification.setToUserId(userId);
                specificNotification.setFromUserId(notification
                        .getFromUserId());
                specificNotification.setEventId(notification.getEventId());
                specificNotification.setExtraMessage(notification
                        .getExtraMessage());
                specificNotification.setNotificationType(notification
                        .getType());

                mgr.makePersistent(specificNotification);

                allDevices.addAll(zeppaUser.getDevices());

            }

        }
        if (!allDevices.isEmpty()) {

            Message msg = new Message.Builder().collapseKey("sendToSync")
                    .build();

            MulticastResult result = sender.send(msg, allDevices, 500);
            result.getTotal();

        }

    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        mgr.close();
    }

}