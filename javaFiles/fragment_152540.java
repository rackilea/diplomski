public class CallingBatch {
public static void main(String[] args) {
Runtime run = Runtime.getRuntime();
try {
run.exec("cmd start /c C:/batfile.bat");
} catch (Exception e) {
e.printStackTrace();
}
System.out.println("FINISHED");
}
}