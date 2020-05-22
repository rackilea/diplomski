BufferedReader br = new BufferedReader(new FileReader("..."));
Scanner sc = new Scanner(br);
sc.useDelimiter("\\$");
while (sc.hasNext())
{
    String text = sc.next();
    System.out.println(text);
    ...
}