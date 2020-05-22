try {
    String[] command = {"java.exe", "mytest.DDD"};
    ProcessBuilder pb = new ProcessBuilder(command);
    // Use this if the place you are running from (start context)
    // is not the same location as the top level of your classes
    //pb.directory(new File("\path\to\your\classes"));
    pb.redirectErrorStream(true);
    Process exec = pb.start();

    BufferedReader br = new BufferedReader(new InputStreamReader(exec.getInputStream()));
    String text = null;
    while ((text = br.readLine()) != null) {
        System.out.println(text);
    }
} catch (IOException exp) {
    exp.printStackTrace();
}