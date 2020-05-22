Runtime runtime = Runtime.getRuntime();
Process process = runtime.exec("ipconfig"); // you might need the full path
InputStream is = process.getInputStream();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader br = new BufferedReader(isr);
String line;

while ((line = br.readLine()) != null) {
    System.out.println(line);
}