InputStream stream = new URI('http://path-to-file').toURL().openStream();
BufferedReader r = new BufferedReader(new InputStreamReader(stream));
String content = "";
while((content = r.readLine()) != null) {
System.out.println(content); // you can put custom logic here.
}