//Creating the first obj
Dummy d = new Dummy(0);
//Creating second ojj
Dummy d2 = new Dummy(0);
LinkedList<Dummy> ll = new LinkedList<Dummy>();


//Since d and d2 are now 2 different objects, a change to d would not have a impact on d2 and vice versa
d.SetData(1);
d2.SetData(2);
ll.add(d);
ll.add(d2);

System.out.println(ll.get(1).data);
System.out.println(ll.get(0).data);