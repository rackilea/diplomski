Scanner file = new Scanner(myFile);
ArrayList<Scanner> lines = new ArrayList<>();
while(file.hasNextLine())
    lines.add(new Scanner(file.nextLine()));
ArrayList<ArrayList<String>> lists = new ArrayList<>(lines.size());
for(Scanner s : lines)
    s.useDelimeter("[, ]" + System.lineSeparator());
for(int i = 0; i < lines.size(); ++i)
{
    while(lines.get(i).hasNext())
    {
        lists.add(new ArrayList<String>());
        lists.get(i).add(lines.get(i).next());
    }
}