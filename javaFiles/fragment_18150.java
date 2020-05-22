BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
String line = null;
while ((line = reader.readLine()) != null)
{
   System.out.println(line);
}