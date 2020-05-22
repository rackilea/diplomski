String fileName = pdfBean.getFileName().tostring();   

private boolean isFtpFileExist(String fileName){
for(FTPFile file : ftpFiles ){

       if (file.getType() == FTPFile.FILE_TYPE) {
            // ....
          if(file.getName().equals(fileName)){
             return true;
          }
        }

    }

 return false;
 }