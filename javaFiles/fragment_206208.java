JFileChooser chooser = new JFileChooser("./hei/");
int returnval = chooser.showOpenDialog(this);
String ServerDirectory=("//" + "JOAKIM-PC"+ "/Users/Public/Server/"); 
if(returnval == JFileChooser.APPROVE_OPTION){
   File file = chooser.getSelectedFile();

   try{
           byte[] filedata = cf.downloadFile2(file.getAbsolutePath());  
           BufferedOutputStream output = new BufferedOutputStream 
                    (new FileOutputStream(ServerDirectory + file.getName())); 
            output.write(filedata,0,filedata.length);
            output.flush();
            output.close();

   }
   catch(Exception e){
      e.printStackTrace();
   }
}