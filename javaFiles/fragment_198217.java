public static void main (String[] args) throws Exception
{
    String startingDate = "25 Mar 2016";
    SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
    sdf.setTimeZone(TimeZone.getTimeZone("IST"));

    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
    System.out.println(sdf.parse(startingDate));
}