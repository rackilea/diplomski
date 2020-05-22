// Suppose you have two lists of Objects (Strings in this case)
List<String> list1 = new ArrayList<String>();
List<String> list2 = new ArrayList<String>();

//fill them with some example data
list1.add("1"); list1.add("2"); list1.add("3"); 
list2.add("0"); list2.add("1"); list2.add("2");

// Now you can use ONE for-loop as you asked to check equality
for (String s : list1) {
    if(list2.contains(s)){ // use contains() method which returns true if the Object found
    // indexOf(Object) this method return the index of the given Object in the list
    // get(int index) this return the OBJECT from the list
    // and because Java works by passing reference of object -> you can directly invoke any method
    // that is originally in that Object Class

       list2.get(list2.indexOf(s)); // you can invoke a method on it 
    // because in this case it's a String I can invoke any method from Class String
    // on the the above-object, for example
       list2.get(list2.indexOf(s)).trim(); // this method to remove leading spaces.. and so on

       System.out.println(list2.get(list2.indexOf(s))); // for testing
    }
}