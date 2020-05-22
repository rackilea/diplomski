InputStream is = this.getClass().getClassLoader().getResourceAsStream("licenca.txt");
BufferedReader in = new BufferedReader(new InputStreamReader(is));
String str;
while ((str = in.readLine()) != null) {
    taLicenca.append(str + "\n");
}