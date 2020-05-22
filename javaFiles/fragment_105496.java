String submitCommand = "/root/spark/bin/spark-submit " + submitParams + " --   class partitioning.PartitionExample /root/partitioning.jar " + javaFlags;
Process p = Runtime.getRuntime().exec(submitCommand);

BufferedReader reader;
String line;

System.out.println(p.waitFor());
reader = new BufferedReader(new InputStreamReader(p.getInputStream()));         
while ((line = reader.readLine())!= null) {
  System.out.println(line);
}