//1. Get the value (list here) for the key you want to add new values. 

ArrayList<Integer> myList =  myMap.get("s");

//2. Check if myList is null
if(myList==null){
    myList = new ArrayList<Integer>();
}

//3. Now add the values to this list.


myList.add(5);