ArrayList<ObjectA> la = new ArrayList<ObjectA>();
List<ObjectA> list = new Gson().fromJson(json, la.getClass());

for (Object a : list)
{
   System.out.println(a);
}