InputStream is = uc.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
String line;

while ((line = br.readLine()) != null) {
    //Apply my criteria here on each line
}