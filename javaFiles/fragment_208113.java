Process p = new ProcessBuilder("ssmtp").start();
PrintStream out = new PrintStream(p.getOutputStream());
String line = null;
BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("msg.txt")));
while((line = in.readLine()) != null)
    out.println(line);
out.close();
in.close();