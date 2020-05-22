//read in chunks of 2KB
byte[] buffer = new byte[2048];
int bytesRead = 0;
try(InputStream is = conn.getInputStream())
{

     try(DataOutputStream os = new DataOutputStream(new FileOutputStream("file.pdf"))
     {
         while((bytesRead = is.read(buffer)) != -1)
         {
            os.write(buffer, 0, bytesRead);
         }     
     }
}
catch(Exception ex)
{
    //handle exception
}