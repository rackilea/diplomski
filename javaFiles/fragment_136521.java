String prog = "C:\\program files\\server\\xampp\\mysql\\bin\\mysql";
    String user = "-uroot";
    String pass = "-ppass";

    ProcessBuilder builder = new ProcessBuilder(prog, user, pass);
    Process runtimeProcess = builder.start();
    int result = runtimeProcess.waitFor();
    //...