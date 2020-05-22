Process p = Runtime.getRuntime().exec("/home/paftdl/NavData/mnt-ddc.sh");
InputStream is = p.getInputStream(); // Let's print what we get.
BufferedReader br = new BufferedReader(new InputStreamReader(is));
String line;
while ((line = br.readLine()) != null) {
  System.out.println(line);
}