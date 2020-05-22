String cmd = "myprog -t";
String arg = "show version";
try {
    Process p = Runtime.getRuntime().exec(cmd);
    PrintStream ps = new PrintStream(p.getOutputStream());
    ps.println(arg);
    ps.flush();
    final StringBuilder sb = new StringBuilder();
    final InputStream is = p.getInputStream();
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append(System.lineSeparator());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
    t.start();
    try {
        p.waitFor();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    try {
        t.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println(sb.toString());
} catch (IOException e) {
    e.printStackTrace();
}