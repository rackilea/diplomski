public static void main(String[] args)
{

  Date d = new Date();
  SimpleDateFormat sdf_us = new SimpleDateFormat("yyyy-MMMM-dd",Locale.US);
  SimpleDateFormat sdf_fr = new SimpleDateFormat("yyyy-MMMM-dd",Locale.FRANCE);
  String output = sdf_us.format(d);
  System.out.println(output);
  System.out.println(d);
  try
  {
    d = sdf_us.parse(output);
    String output_fr = sdf_fr.format(d);
    d = sdf_fr.parse(output_fr);
    System.out.println(output_fr);
    System.out.println(d);
  }
  catch (ParseException e)
  {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
}