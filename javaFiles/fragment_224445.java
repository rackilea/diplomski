List<HashMap<String, String>> valuesList =
    new ArrayList<HashMap<String, String>>();

for (int i = 0; i < 4; i++)
{
    HashMap<String, String> m = new HashMap<String, String>();
    m.put("white", "white_name" + i);
    m.put("blue",  "blue_name"  + i);
    valuesList.add(m);
}

System.out.println(valuesList.toString());