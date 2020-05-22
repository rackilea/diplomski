BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "UTF-8"));
PrintWriter writer = new PrintWriter(new OutputStreamWriter(someOutputStream, "UTF-8"));

for (String line; (line = reader.readLine()) != null;) {
    processIfNecessary(line);
    writer.writeln(line);
}