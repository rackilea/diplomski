class SO {
public static void main(String args[]) {
try {
    Process proc = Runtime.getRuntime().exec("your command");
    proc.waitFor(); //Wait for it to finish
    System.exit(0);
} catch (IOException e) {
    e.printStackTrace();
} catch (InterruptedException e) {
    e.printStackTrace();
}
}
}