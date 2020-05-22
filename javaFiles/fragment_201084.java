File direct = new File(Environment.getExternalStorageDirectory() + "/urfoldername/");
if(!direct.exists())
               {
                   direct.mkdir(); //directory is created;

               }
 file = new File("/sdcard/urfoldername/"+fileName);
 InputStream input = new BufferedInputStream(url.openStream());
 OutputStream output = new FileOutputStream(file);
 byte data[] = new byte[1024];
         while ((count = input.read(data)) != -1) 
                       {
               total += count;
               output.write(data, 0, count); 
               }
                 output.flush();
                 output.close();
                 input.close();