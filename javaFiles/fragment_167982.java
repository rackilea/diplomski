List<? extends Number> list1 = new ArrayList<Number>(){
    {addAll(Arrays.asList(1,2,3,4,5));}
};
ListIterator<? extends Number>  listIterator = list1.listIterator();
listIterator.next();
listIterator.set(999);
System.out.println(list1);