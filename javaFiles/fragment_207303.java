BufferedReader pmi = new BufferedReader(new FileReader("/proc/meminfo"));
try {
  String line;
  while ((line = pmi.readLine()) != null)
    if (line.contains("MemTotal"))
       // get the second word as a long.
       return Long.parseLong(line.split(" +",3)[1]); 
  return -1;
} finally {
  pmi.close();
}