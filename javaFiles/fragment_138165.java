//Process exec = Runtime.getRuntime().exec("C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump "+fisier.getName()+" > C:\\"+fisier.getName()+".sql;");

Process exec = Runtime.getRuntime().exec(new String[]{"cmd.exe","/c","C:\\Program Files\\MySQL\\MySQL Server 5.6\\bin\\mysqldump "+fisier.getName()+" > C:\\"+fisier.getName()+".sql;"});

//Wait for the command to complete, and check if the exit value was 0 (success)
if(exec.waitFor()==0)
{
    //normally terminated, a way to read the output
    InputStream inputStream = exec.getInputStream();
    byte[] buffer = new byte[inputStream.available()];
    inputStream.read(buffer);

    String str = new String(buffer);
    System.out.println(str);
}
else
{
    // abnormally terminated, there was some problem
                //a way to read the error during the execution of the command
    InputStream errorStream = exec.getErrorStream();
    byte[] buffer = new byte[errorStream.available()];
    errorStream.read(buffer);

    String str = new String(buffer);
    System.out.println(str);

}