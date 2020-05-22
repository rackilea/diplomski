ExecutorService svc = Executors.newCachedThreadPool();

URLConnection c = 
    new URL("http://192.168.1.122/push/out.php?nduid=1").openConnection();
c.setReadTimeout(30 * 60 * 1000); // Set the read timeout to 30 minutes
c.connect();
InputStream is = c.getInputStream();
BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF-8"));

String cmd = null;
while ((cmd = r.readLine()) != null) {
  svc.execute(new Runnable() {
    public void run() {
      processCmd(cmd); // work happens here in a different thread.
    }
  });
}

is.close();