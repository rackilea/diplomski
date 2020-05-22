ArrayList<String> state = new ArrayList<String>();
StringBuilder a = new StringBuilder("A")
//Do whatever you want to a
state.add(a.toString());
state.add(b.toString());
state.add(c.toString());
state.add(d.toString());
.....
System.out.println(state.indexOf("B")); //Out: 1