public static void main(String[] args) {
    while (true) {
        try {
            Thread.sleep(60*1000); //one minute

            Calendar calendar = new GregorianCalendar();
            String hour;
            int time = calendar.get(Calendar.HOUR);
            int m = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            if(calendar.get(Calendar.AM_PM) == 0)
                hour = "A.M.";
            else
                hour = "P.M.";
            System.out.println(time + ":" + m + ":" + sec + " " + hour);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}