//Server
server.addLifeCycleListener(new AbstractLifeCycle.AbstractLifeCycleListener() {
    @Override
    public void lifeCycleStarted(LifeCycle event) {
       System.out.println(STARTED_MESSAGE);
    }
});


//CLI
Process warProcess = Runtime.getRuntime().exec("java -jar " + options.getWarFile());
InputStream inputStream = warProcess .getInputStream();
InputStreamReader streamReader = new InputStreamReader(inputStream);
BufferedReader bufferedReader = new BufferedReader(streamReader);
String line;
while ((line = bufferedReader .readLine()) != null) {
  if (line.contains(STARTED_MESSAGE)) {
     System.exit(0);
  }
}