Scanner s = new Scanner(new File(//Here the path of your file));

ArrayList<String> list = new ArrayList<String>();

while (s.hasNext())
{
    list.add(s.nextLine());
}