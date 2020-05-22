FTPFile[] list = client.list();
for (int i = 0; i < list.length; i++)
{
   //client.download("localFile", new java.io.File("remotefile);
    client.download(list[i].getName(), new java.io.File(list[i].getName());    
}