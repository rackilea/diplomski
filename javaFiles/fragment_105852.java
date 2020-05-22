public static void main(String[] args) throws Exception {
    String command = "cmd /c tasklist /svc | findstr \"svchost.exe\"";
    Process p = Runtime.getRuntime().exec(command);
    while(p.getInputStream().read() != -1) {} //hangs without this line

    System.out.println("Return code: " + p.waitFor());

}