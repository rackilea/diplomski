BufferedReader br = new BufferedReader(new InputStreamReader( httpCon.getInputStream(),"utf-8"));
String line = null;
while ((line = br.readLine()) != null) {
    sb.append(line + "\n");
}
br.close();
System.out.println(""+sb.toString());