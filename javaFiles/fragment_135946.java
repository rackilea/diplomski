public static String uploadOrder(String fileName)
{

    String m;

    FTPClient con = null;

    m = "Conn failed";

    try
    {
       con = new FTPClient();

       con.connect("xxx.xxx.210.176");

       //username and password for ftp server
       if (con.login("ftpxxx@xxxxx", "pass"))
       {
          con.enterLocalPassiveMode();//passive mode - IMPORTANT
          con.setFileType(FTP.ASCII_FILE_TYPE);//only for txt file ACII mode, for rest binary mode
          String data = Environment.getExternalStorageDirectory().getPath() +"/"+ fileName; //data location 
          FileInputStream in = new FileInputStream(data);
          File f = new File(data);          

          con.changeWorkingDirectory("xxxxxx");//        
          if(con.changeWorkingDirectory("Orders"))//
          {
             Log.i("FTP","Got into directory");
          }
          if(!con.changeWorkingDirectory(MainPage.fb_id))//
          {

              in.close();
              con.logout();
              con.disconnect();
              return m;
          }


          if(con.storeFile(fileName, in))
          {               
              m = "Upload success!";
          }
          if(!f.exists()) m = "File not exists.";
          in.close();
          //logging out
          con.logout();
          con.disconnect();
       }
       else 
       {                     
           m = "Unsuccessful";
       }
    }
    catch (Exception e)
    {
          m = e.getMessage();
    }
    return m;
}