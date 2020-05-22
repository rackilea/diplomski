public static void main(String[] args) throws InterruptedException
{
    // TODO Auto-generated method stub
    try
    {
        String line, commandInput;
        ProcessBuilder telnetProcessBuilder = new ProcessBuilder("/bin/bash");
        telnetProcessBuilder.redirectErrorStream(true);
        Process telnetProcess = telnetProcessBuilder.start();
        BufferedReader input = new BufferedReader(new InputStreamReader(telnetProcess.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(telnetProcess.getOutputStream()));
        commandInput = "ls -l\n";
        output.write(commandInput);
        output.flush();
        commandInput = "pwd\n";
        output.write(commandInput);
        output.flush();
        commandInput = "whoami\n";
        output.write(commandInput);
        output.flush();
        commandInput = "exit\n";
        output.write(commandInput);
        output.flush();
        while((line = input.readLine())!= null)
            System.out.println(line);
    }
}