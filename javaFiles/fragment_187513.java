// Adding element in list
list.add("1")
list.add("-");
list.add("23");
list.add("+");
list.add("123");
list.add("-");
// Size of List 
int size = list.size();
// Getting Last element
String  lastValue = list.get(size-1);
// check the length of last element
if(lastValue.length()<=1)
     list.remove(size - 1);
else
     list.set(size-1,lastValue.substring(0,lastValue.length()-1));