String student = "Bobby";
int mark = 85;
if (map.containsKey(student))
  map.get(student).add(mark);
else
{
  ArrayList<Integer> arr = new ArrayList<Integer>();
  arr.add(mark);
  map.put(student, arr);
}