public static void main(String[] args) throws Exception{
        String path = "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe";
        String command1 ="cmd /c \"cd C:\\test && " + path + " /c .\\test.ps1\"";
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(command1);
        Thread.sleep(2000);
        proc.destroy();
    }