public static void main(String args[]) {
        /* Set the Nimbus look and feel */
       /* Create and display the form */
        String startupPath=System.getProperty("java.library.path");
        System.out.println![enter image description here][1]("LibraryPath -1:"+startupPath);
        String[] trim=startupPath.split(";");
        if(trim.length > 0){
            String firstPath=trim[0];
            System.out.println("firstPath :"+firstPath);
            String destPath=firstPath+"\\rxtxSerial.dll";
            File destinationFile=new File(destPath);
            if(!destinationFile.exists()){
                try {
                InputStream dllStream=Base.class.getClassLoader().getResourceAsStream("dllPack/rxtxSerial.dll");
                    FileOutputStream fos = null;
                    try{
                    fos = new FileOutputStream(destPath);
                    byte[] buf = new byte[2048];
                    int r = dllStream.read(buf);
                    while(r != -1) {
                        fos.write(buf, 0, r);
                        r = dllStream.read(buf);
                    }
                    }finally{
                        if(fos!=null){
                           fos.close();
                        }
                    }
                 System.out.println("Complated...");
                } catch (IOException ex) {
                    Logger.getLogger(Base.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Problem occured closing...");
                    System.exit(0);
                }
            }

        }