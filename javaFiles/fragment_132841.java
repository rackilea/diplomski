public class Main {
public static void main(String[] args) {
    Terminal commandLine = new Terminal();

    try {
        commandLine.executeCommand('p');

    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}