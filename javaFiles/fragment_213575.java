List<? super Integer> list;
Integer e = 2;

list = new ArrayList<Integer>();
list.add(e);

list = new ArrayList<Number>();
list.add(e);

list = new ArrayList<Object>();
list.add(e);