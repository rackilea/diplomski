public class Example{
    public static void main(String args[]){
        String[] command = new String[] {
            "/bin/sh", "-c", "sleep 10; mv /home/file /home/file1"
        };
        Process process = new ProcessBuilder(command).start(); 
        somefunction();
        process.waitFor();
   }