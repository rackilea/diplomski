ProcessBuilder pb = new ProcessBuilder("bin/telegram-cli","-k","tg-server.pub","-W","-U","root");
pb.directory(new File("/var/java/apache-tomcat-7.0.47/webapps/Telegram/tg"));
Process p = pb.start();
try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()),true)) {
    String line = null;
    pw.println("contact_list");
    while ((line = br.readLine()) != null) {
        System.out.println("line = " + line);
    }
}