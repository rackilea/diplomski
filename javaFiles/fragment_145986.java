public static void main(String[] args) throws ParseException {
    SimpleDateFormat df = new SimpleDateFormat("HHmmss");
    String myTime = "090000";
    for(int i=0;i<3;i++){
        Date d = df.parse(myTime); 
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.SECOND, 60);
        String newTime = df.format(cal.getTime());
        System.out.println("Start time : "+myTime);
        System.out.println("end Time   :"+newTime);

        // now add 10 minutes to the start time
        cal.setTime(d);
        cal.add(Calendar.MINUTE, 10);
        myTime = df.format(cal.getTime());
    }
}