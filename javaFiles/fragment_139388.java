BufferedReader br = new BufferedReader(new FileReader("Customers.txt"));
String line;

while ((line = br.readLine()) != null)
{
    ...
}

br.close();