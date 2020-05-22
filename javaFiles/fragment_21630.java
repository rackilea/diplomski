BufferedReader in = new BufferedReader(new  InputStreamReader(new FileInputStream(src)));
OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(dest));
String line;
while ((line = in.readLine()) != null) {
   String stringOut = line.replaceAll("\"", "");
   out.write(stringOut);
}

in.close();
out.close();