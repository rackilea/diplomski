public class App{

   public static void main(String... args) throws Exception {
      while (true) {
         Process process = Example.startMinecraft(args);
         // Stops for sixty seconds
         Thread.sleep(1000 * 60);

         BufferedWriter out = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
         out.write("stop");

         // Wait for the process to stop
         process.waitFor();

         // Now start your Backup
         Process backupProcess = Example.startBackup();
         backupProcess.waitFor();

         // After your backup completed your minecraft server will start again
      }

   }

   private static Process startMinecraft(String... args) throws IOException {
      final ProcessBuilder processBuilder = new ProcessBuilder();
      processBuilder.directory(new File("C:/Users/trudler/Desktop/New folder (4)/"));
      processBuilder.command("java", "-jar", "server.jar");
      Process process = processBuilder.start();

      InputStream is = process.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);

      Thread t1 = new Thread(() -> {
         try {
            String line;
            System.out.printf("Output of running %s is:", Arrays.toString(args));
            while ((line = br.readLine()) != null) {
               System.out.println(line);
            }
         } catch (IOException e) {
            // Do something when the Exception is thrown
         }
      });
      t1.start();

      return process;
   }

   private static Process startBackup(){
      // Here you have to build your backup process
   }
}