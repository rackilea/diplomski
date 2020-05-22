File f = new File(filePathString);
if(!f.exists() && !f.isDirectory()) { 
 startDownload();
 readFile();
} 
else { 
   try { 
      file.delete();
   } catch (Exception e) { 
      e.printStackTrace();
   }

}