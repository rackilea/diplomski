final String GCM_API_KEY = "yourKey";
    final int retries = 3;
    final String notificationToken = "deviceNotificationToken";
    Sender sender = new Sender(GCM_API_KEY);
    Message msg = new Message.Builder().build();

    try {
                Result result = sender.send(msg, notificationToken, retries);

                if (StringUtils.isEmpty(result.getErrorCodeName())) {
                    logger.debug("GCM Notification is sent successfully");
                    return true;
                }

                logger.error("Error occurred while sending push notification :" + result.getErrorCodeName());
    } catch (InvalidRequestException e) {
                logger.error("Invalid Request", e);
    } catch (IOException e) {
                logger.error("IO Exception", e);
    }
    return false;