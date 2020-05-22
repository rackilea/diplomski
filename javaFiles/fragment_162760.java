try {
    String[] command = {"java.exe", "-?"};
    ProcessBuilder pb = new ProcessBuilder(command);
    pb.redirectErrorStream(true);
    Process exec = pb.start();

    BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    String text = null;
    while ((text = br.readLine()) != null) {
        System.out.println(text);
    }

    System.out.println("Process exited with " + exec.waitFor());
} catch (IOException | InterruptedException exp) {
    exp.printStackTrace();
}