public enum BlinkLedTask {
(...)

    private Process resetLedProcess;
    private Process blinkLedProcess;

(...)
   private void blinkLed() throws Exception {
      String[] args = new String[] { frequency[0], frequency[1], frequency[2] };

      List<String> commands = new ArrayList<>();

      //commands.add(BASH);
      commands.add(script.getAbsoultePath());

      if (Objects.nonNull(args)) {
        commands.addAll(Arrays.asList(args));
      }

      StringBuilder builder = new StringBuilder("Executing script: ");
      builder.append(script.getAbsoultePath());

      if (Objects.nonNull(args) && (args.length > 0)) {
        builder.append(" with parameters: ");
        builder.append(StringUtils.join(args, " "));
      }


      ProcessBuilder processBuilder = new ProcessBuilder(commands.toArray(new String[commands.size()]));

      blinkLedProcess = processBuilder.start();

      StringBuilder outputBuilder = new StringBuilder();
      InputStream inputStream = blinkLedProcess.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

      String line = StringUtils.EMPTY;

      while ((line = bufferedReader.readLine()) != null) {
        outputBuilder.append(line);
        outputBuilder.append("\n");
      }


      blinkLedProcess.waitFor();

      int exitValue = blinkLedProcess.exitValue();
      System.out.println(
        "Process for: " + Script.BLINK_LED.getAbsoultePath() + " is executed. Exit value: " + exitValue);


    }

(...)

   private void terminate() {
      System.out.println("Stopping - " + Thread.currentThread().getName());
      running = false;
      if (resetLedProcess != null) {
        resetLedProcess.destroy();
        System.out.println("Destroyed reset process");
      }
      if (blinkLedProcess != null) {
        blinkLedProcess.destroy();
        System.out.println("Destroyed blink process");
      }
    }
(...)
}