File mainFolder = new File("C:\\yourDir");
getFiles(mainFolder);

public void getFiles(File f)
{
   File files[];
   if(f.isFile())
   System.out.println(f.getAbsolutePath());
   else
   {
      files = f.listFiles();
      for (int i = 0; i < files.length; i++) 
      {
         getFiles(files[i]);
      }
  }
}