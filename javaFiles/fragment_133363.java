Timer timer = new Timer();
    timer.schedule(new TimerTask() {

        @Override
        public void run() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date currentDate = null;
            Date destinationDate = null;
            try {
                currentDate = Calendar.getInstance().getTime();
                destinationDate = sdf.parse("2019-05-15T09:00:00");

            } catch (ParseException e) {
                e.printStackTrace();
            }

            calculateDifference(currentDate, destinationDate);

        }

    }, 0, 1000);//Update text every second
}