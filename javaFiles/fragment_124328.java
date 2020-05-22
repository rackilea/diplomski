new Thread(new Runnable() {
        @Override
        public void run() {

            //some work here

            Log.d("job","notification sent");

            Notification notification = new Notification.Builder(context)
                    .setContentTitle("Job performed")
                    .setContentText("Job performed on " + Calendar.getInstance().getTime().toString())
                    .setSmallIcon(R.drawable.icon_vec_andro_black)
                    .build();

            NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            nManager.notify(jobParameters.getJobId()+111,notification);

            jobFinished(jobParameters, true);
        }
    }).run();