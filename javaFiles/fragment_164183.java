// with array 
YourCustomClass [] array = new YourCustomClass[10];
array[0] = new YourCustomClass();
array[0].setID("yourid");

String id = array[0].getID();

// with arraylist
ArrayList<YourCustomClass> arraylist = new ArrayList<YourCustomClass>();
arraylist.add(new YourCustomObject());
arraylist.get(0).setID("yourid");

String id = arraylist.get(0).getID();