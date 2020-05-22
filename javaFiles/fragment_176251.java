public static void main(String args[])
    {
        String strlastruntime ="16/06/2016 9:17:00 AM",dateFormat ="dd/MM/yyyy hh:mm:ss a";

        try
        {
            strlastruntime = strlastruntime.trim();
            System.out.println("strlastruntime = "+strlastruntime+" dateFormat = "+dateFormat);
            java.util.Locale l = java.util.Locale.US;
            java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(dateFormat,l);
            //System.out.println("formatter = "+formatter);
            java.util.Date date = formatter.parse( strlastruntime );
            System.out.println("date = "+date);
            long time = date.getTime();
            System.out.println("time = "+time);

        }
        catch(java.text.ParseException ee)
        {
            ee.printStackTrace();
            System.out.println(ee);
        }
    }