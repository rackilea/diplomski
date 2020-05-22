BufferedReader flux_in = new BufferedReader(new InputStreamReader(new FileInputStream("abc.txt"))); 
String line;
while ((line = flux_in.readLine()) != null)
{
    System.out.println(line);
}