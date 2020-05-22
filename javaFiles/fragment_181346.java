OBJ obj1=new OBJ();
 obj1.arraylist.add("f");
 .
 .
//add some data to obj1 like 
OBJ obj2=new OBJ();
obj2=(OBJ)obj1.clone();
obj2.arrarylist=new Arraylist<OBJ>();
obj2.arraylist.add(obj1.arraylist.get(0));