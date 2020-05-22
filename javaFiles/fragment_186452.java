private static String multiMediaFolder;
private static long freeDiskSpace;
private static double sizeInGigaByte;


public static void main(String[] args) {

   if (System.getProperty("os.name").equals("Mac OS X")){
       multiMediaFolder = "/Volumes/Multimedia/movies/HD";
       freeDiskSpace = new File(multiMediaFolder).getFreeSpace();
       sizeInGigaByte = (double) freeDiskSpace / 1024 / 1024;
   } else if (System.getProperty("os.name").substring(0, 7).equals("Windows")){
       multiMediaFolder = "\\\\QNAP\\Multimedia\\movies\\HD";
       freeDiskSpace = new File(multiMediaFolder).getFreeSpace();
       sizeInGigaByte = (double) freeDiskSpace / 1024 / 1024 / 1024;
   }

   System.out.println(sizeInGigaByte);
}