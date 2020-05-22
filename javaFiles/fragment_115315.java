File dir = new File(dirPath);
File[] files = dir.listFiles((FileFilter) HiddenFileFilter.VISIBLE);

Map<String, ArrayList<Long>> mimeArray = new HashMap();

if (files.length == 0) {
    System.out.println("The directory is empty");
} 
else {
     for (File aFile : files) {
         if (!mimeArray.keySet().contains(mtftp.getContentType(aFile))) {
             mimeArray.put(mtftp.getContentType(aFile), 0L);
         }
         mimeArray.get(mtftp.getContentType(aFile)) += aFile.length;
     }
}