List<String> originalList = new List<String>();

originalList.add("hi");
originalList.add("hello");
originalList.add("bye");

List<String> listofStringsTwo = new List<String>();

for (int i=0; i<original.size ; i++)
{
  String temp = "";
  for (int j=0;j<=i;j++)
  {
    temp += original.get(j) + " ";
  }
  listofStringsTwo.add( temp );
}