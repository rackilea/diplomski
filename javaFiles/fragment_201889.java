public int compare(File f1, File f2)
{
    Date d1 = fileNameToDate(f1);
    Date d2 = fileNameToDate(f2);
    return d1.compareTo(d2);
}

//caution: this static is better for performance, but may not be thread-safe
private static SimpleDateFormat DF_YYYYMMDD = new SimpleDateFormat("yyyyMMdd");

private Date fileNameToDate(File f)
{
   int pos = f.getName().lastIndexOf('_');
   if (pos < 0)
   {
     //TODO: error handling if filename is not in the correct format
   }
   String dateStr = f.getName().substring(pos + 1, pos + 1 + 8);
   try
   {
     return DF_YYYYMMDD.parse(dateStr);
   }
   catch(ParseException e)
   {
     //TODO: error handling if filename is not in the correct format        
   }
}