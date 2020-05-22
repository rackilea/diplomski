List<Integer> list = new ArrayList<Integer>();
list.add(1);
Iterator<Integer> it = list.iterator();

it.next(); // return 1;

list.add(2);// the list is modified 
it.next();
// ^--- fail-fast throws a ConcurrentModificationException