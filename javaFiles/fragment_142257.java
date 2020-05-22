public static void main (String[] args)
{
    try{
        SimpleDateFormat xedFormat = new SimpleDateFormat("MMMM dd yyyy hh:mma"); 
        SimpleDateFormat pedFormat = new SimpleDateFormat("yyyyMMdd"); 
        System.out.println("output : "+pedFormat.format(xedFormat.parse("Oct 31 2015 12:00AM")));
    }
    catch(Exception e){
        System.out.println("e: "+e);
}