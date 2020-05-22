String[] part2 = part[1].replace("(", "").trim().split(")");
List<String> indices = new ArrayList<String>();
List<String> weights= new ArrayList<String>();
List<String> values = new ArrayList<String>();

for (String s : part2)
{
   String item = s.split(",");
   indices.add(item[0]);
   weights.add(item[1]);
   values.add(item[2]);
}

// to get them as arrays
String[] allWeightsArray = weights.toArray(new String[]); ...