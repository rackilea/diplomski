public static void main(String[] args) {
Integer one = new Integer(1);
Integer two = new Integer(2);
Integer three = new Integer(3);

List<Integer> list = new LinkedList<Integer>();
list.add(one);
list.add(two);
list.add(three);
list.add(new Integer(1));
list.add(new Integer(2));
list.add(new Integer(3));

System.out.println("Full list: " + list);