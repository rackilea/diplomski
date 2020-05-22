BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));
Map<Integer, String> items = new TreeMap<Integer, String>();

String line;
while (null != (line = br.readLine()))
{
    String[] line_parts = line.split(" ");
    if (line_parts.length > 1)
    {
        StringBuilder desc = new StringBuilder(line_parts[1]);
        for (int i = 2; i < line_parts.length; i++)
        {
            desc.append(line_parts[i]);
        }
        items.put(new Integer(line_parts[0]), desc.toString());
    }
}

for (Integer key: items.keySet())
{
    System.out.println(key + " = " + items.get(key));
}