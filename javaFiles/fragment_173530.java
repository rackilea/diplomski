Process process = runtime.exec("ls -l");
InputStream inputStream = process.getInputStream();
InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

for(String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
  System.out.println("Process output: " + line);
}