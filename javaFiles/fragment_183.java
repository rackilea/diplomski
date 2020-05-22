HashSet s0 = new HashSet(arraylist0);
s0.retainAll(arraylist1);
System.out.println("Intersection: " + s0);

s0 = new HashSet(arraylist0);
s0.addAll(arraylist1);
System.out.println("Union: " + s0);