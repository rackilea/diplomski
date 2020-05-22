public static List<String> getLogFiles(String logLocation, final String pattern, String date) throws ParseException
{
   File logDirectory = new File(logLocation);
   String[] files = new String[] {};

   SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
   Date d = f.parse(date);
   long milliseconds = d.getTime();

   if (logDirectory.isDirectory())
   {
     files = logDirectory.list(new FilenameFilter()
     {

        @Override
        public boolean accept(File dir, String name)
        {
            return name.matches(pattern) && new File(dir, name).lastModified() > milliseconds;
        }
    });
  }
  return Arrays.asList(files);
}