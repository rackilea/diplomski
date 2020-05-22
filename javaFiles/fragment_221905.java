// The PendingIntent to launch our activity if the user selects this notification
    PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
            new Intent(this, LocalServiceActivities.Controller.class), 0);

    // Set the info for the views that show in the notification panel.
    notification.setLatestEventInfo(this, getText(R.string.local_service_label),
                   text, contentIntent);