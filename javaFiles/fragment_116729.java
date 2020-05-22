ProcessBuilder builder = 
           new ProcessBuilder("enq", "-P", "QueueName", "FileName");
Process process = builder.start();
InputStreamReader streamReader = new InputStreamReader(process.getInputStream());
BufferedReader reader = new BufferedReader(streamReader);
String line;
while ((line = reader.readLine()) != null) {
   System.out.println(line);
}