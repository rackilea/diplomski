final Process p = pb.start();
// then start a thread to read the output.
new Thread(new Runnable() {
  public void run() {
    BufferedReader output = new BufferedReader(
        new InputStreamReader(p.getInputStream()));
    String line;
    System.out.print("Result : ");
    while ((line = output.readLine()) != null) {
     System.out.println(line);
    }
  }
}).start();
p.waitFor();