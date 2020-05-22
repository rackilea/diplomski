class Driver(String args)
{
   ProcessDirectories pd = ...
   BlockingQueue<DirectoryData> dirQueue = new LinkedBlockingQueue<DirectoryData>();
   new Thread(new Runnable(){public void run(){pd.addDirs(dirQueue);}}).start();

   ProcessMatches pm = ...
   BlockingQueue<File> fileQueue = new LinkedBlockingQueue<File>();
   new Thread(new Runnable()
     {
       public void run()
       { 
         for (DirectoryData dir = dirQueue.take(); dir != DIR_POISON; dir = dirQueue.take())
         {
           for (File file : dir.getFiles())
           {
             if (pm.matches(data))
               fileQueue.add(file)
           }
         }
         fileQueue.add(FILE_POISON);
       }
     }).start();

   for (File file = fileQueue.take(); file != FILE_POISON; file = fileQueue.take())
   {
     output(file);
   }
}