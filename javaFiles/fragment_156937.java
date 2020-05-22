BufferedReader br = new BufferedReader( new InputStreamReader(resStream, "UTF-8") );
StringBuilder sb = new StringBuilder();
String line;
while ( (line = br.readLine()) != null) {
    sb.append(line).append(System.lineSeparator());
}