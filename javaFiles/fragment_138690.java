public Boolean execCommand(String command) 
{
    try {
        Runtime rt = Runtime.getRuntime();
        Process process = rt.exec("su");
        DataOutputStream os = new DataOutputStream(process.getOutputStream()); 
        os.writeBytes(command + "\n");
        os.flush();
        os.writeBytes("exit\n");
        os.flush();
        process.waitFor();
    } catch (IOException e) {
        return false;
    } catch (InterruptedException e) {
        return false;
    }
    return true;
}