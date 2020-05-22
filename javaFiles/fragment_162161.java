import java.io.*;

class RuntimeExecLinux {
  public static void main(String[] args){
      try {
        // Execute a command with arguments
        String[] cmd = new String[]{"/bin/bash", "-c", "echo 'my text from java' >> file.txt"};
        Process child = Runtime.getRuntime().exec(cmd);

        cmd = new String[]{"/bin/bash", "-c", "cat file.txt"};
        child = Runtime.getRuntime().exec(cmd);

        // Get the input stream and read from it
        InputStream in = child.getInputStream();
        int c;
        while ((c = in.read()) != -1) {
            System.out.print((char)c);
        }
        in.close();

      } catch (IOException e) {
        e.printStackTrace();
      }
  }
}