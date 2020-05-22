public static void main(String[] args) throws Exception {
    String command = "tasklist /svc | findstr \"svchost.exe\"";
    Process p = Runtime.getRuntime().exec(command);

    new Thread(new Writer(p.getInputStream())).start();
    new Thread(new Writer(p.getErrorStream())).start();

    System.out.println("Return code: " + p.waitFor());

}