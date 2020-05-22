int index = 0, i = 0;
Stack<String> al = new Stack<String>();
while((index = path.lastIndexOf()))!=-1 && i < 3) {
    al.push((path = path.substring(index)));
    i++;
}
String[] parts = (String[])al.toArray(); //if you don't have array elements
                                         // in correct order, you can use 
                                         // Collections.reverse with Arrays.asList 
                                         // applied on array