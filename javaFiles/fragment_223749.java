public class RunSysCmd {

/**Executes the Linux command necessary for sorting
 * @param String
 */
public static void main(String[] args) {

    try {
        // command to be executed
        String cmd = "/usr/bin/sort -n -k1 /home/General_DataStructure/r1.nmea /home/General_DataStructure/r2.nmea";

        // new file where the result will be stored
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("/home/General_DataStructure/r3.nmea")));
        String line;

        // run the command specified in the cmd variable
        final Process process = Runtime.getRuntime().exec(cmd);

        // read the result executed by the previous command
        BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // write the output of the command to new file
        while ((line = buf.readLine())!=null) {
            out.write(line);
            out.newLine();

        }

        // close the file
        buf.close();
        out.close();

        // causes the thread to wait until the process represented by this Process object the is terminated
        process.waitFor();

        // get the return value of the process. The value 0 means successful execution of the thread
        int returnCode = process.exitValue();
        System.out.println(returnCode);

    } catch (IOException e) {
        e.printStackTrace();

    }

    catch (InterruptedException e) {
        e.printStackTrace();

    }

  }// main ends here
 }