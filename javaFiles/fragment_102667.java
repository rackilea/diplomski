String[] s = "125, 136, 1**, 154, 200, 201, 250, 2**, 304, 307".split(", ");
ArrayList<String> withAsterik = new ArrayList();
ArrayList<String> withoutAsterik = new ArrayList();

for(String str : s)
{
  if(str.contains("**")){
    System.out.println(str);
    withAsterik.add(str);
  }
  else
     withoutAsterik.add(str);
}