// remove the EXTRACT string from the output folder path.I think there is no extract directory 

File outputfolder = new File(file.getParent()+File.separator+"EXTRACT");
.
.
.
   while((ZENTRY=zis.getNextEntry())!=null){
  // remove the outputfolder.getAbsolutePath()
  File file1 = new File(outputfolder+File.separator+ZENTRY.getName());
            new File(file1.getParent()).mkdirs();
            System.out.println("filename::"+ file1.getName()+"::"+file1.isDirectory());
            if(!file1.isDirectory()){
                fos = new FileOutputStream(file1);
                int len;
                while((len=zis.read())>-1){

                    fos.write(len);
                }
                System.out.println("file name on read::"+ file1);
            }