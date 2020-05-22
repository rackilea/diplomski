public void showNotification( CharSequence tag, CharSequence contentTitle, CharSequence contentText, int flag) {
    String ns = Context.NOTIFICATION_SERVICE;
    context = cordova.getActivity().getApplicationContext();
    mNotificationManager = (NotificationManager) context.getSystemService(ns);

    Notification noti = StatusNotificationIntent.buildNotification(context, tag, contentTitle, contentText);
    mNotificationManager.notify(tag.hashCode(), noti);
}