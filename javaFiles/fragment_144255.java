//set test = 1, the first entry in the list
test = users.get(0); 
//get a new iterator, starting before the first element
it9 = users.iterator(); 
// move to first element (the next one), so temp == 1
temp = it9.next(); 
// print values "1 1"
System.out.println(test+" "+temp);