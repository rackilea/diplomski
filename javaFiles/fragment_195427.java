public Boolean execCommands(String... command) {
    try {
        Runtime rt = Runtime.getRuntime();
        Process process = rt.exec("su");
        DataOutputStream os = new DataOutputStream(process.getOutputStream());

        for(int i = 0; i < command.length; i++) {
            os.writeBytes(command[i] + "\n");
            os.flush();
        }
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