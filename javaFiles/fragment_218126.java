List<MyClass> list = new ArrayList<>(someNumber);


for(int i=0;i<someNumber;i++){
     String s = new String(Integer.toString(i));
     MyClass mc = new MyClass();  // create new object mc 
     mc.setString(s);
     list.add(mc); // add the new object to the list
}