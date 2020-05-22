public ArrayList<String> myList = new ArrayList<String>();

...

myList.add("blah");

...

for(int i = 0, l = myList.size(); i < l; i++) {
  // do stuff with array items
  Log.d("myapp", "item: " + myList.get(i));
}