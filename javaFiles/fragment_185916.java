BufferedReader in = new BufferedReader(retrievedFile);
String line = null;
StringBuilder rslt = new StringBuilder();
while ((line = in.readLine()) != null) {
    rslt.append(line);
}
System.out.println(rslt.toString());