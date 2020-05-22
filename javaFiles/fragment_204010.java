public class Main {

public static void main(String[] args) throws IOException {
    String[] command = {"/bin/bash", "test.sh", "Argument1"};
    ProcessBuilder p = new ProcessBuilder(command);
    Process p2 = p.start();
    BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()));
    String line;

    System.out.println("Output of running " + command + " is: ");
    while ((line = br.readLine()) != null) {
        System.out.println(line);
    }
}