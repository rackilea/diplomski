//send notification
private void sendNotification() {
            AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            assert audio != null;
            switch (audio.getRingerMode()) {
                case AudioManager.RINGER_MODE_NORMAL:
                    break;
                case AudioManager.RINGER_MODE_SILENT:
                    break;
                case AudioManager.RINGER_MODE_VIBRATE:
                    break;
            }

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .setAutoCancel(true)
                    .setGroupSummary(true);

            // Since android Oreo notification channel is needed.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                int importance = NotificationManager.IMPORTANCE_LOW;
                NotificationChannel notificationChannel = new NotificationChannel("chanelid", "Notification", importance);
                notificationChannel.enableLights(true);
                assert notificationManager != null;
                notificationBuilder.setChannelId("chanelid");

                if (notificationManager != null) {
                    List<NotificationChannel> channelList = notificationManager.getNotificationChannels();
                    for (int i = 0; channelList != null && i < channelList.size(); i++) {
                        notificationManager.deleteNotificationChannel(channelList.get(i).getId());
                    }
                }

                notificationManager.createNotificationChannel(notificationChannel);
            }
            notificationManager.notify(1, notificationBuilder.build());
        }