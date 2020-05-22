byte[] bytes = file.getBytes();
ByteArrayInputStream inputFilestream = new ByteArrayInputStream(bytes);
BufferedReader br = new BufferedReader(new InputStreamReader(inputFilestream ));
String line = "";
while ((line = br.readLine()) != null) {
System.out.println(line);
}
br.close();