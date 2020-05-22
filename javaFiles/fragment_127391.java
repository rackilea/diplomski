public class MillisecondToDate {
    public static void main(String[] args)throws Exception {
        long yourmilliseconds = 1119193190;
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");

        Date resultdate = new Date(yourmilliseconds);
        System.out.println(sdf.format(resultdate));  
    } 
}