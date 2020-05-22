Object[] objArray = { new Object(), new Object() };
ListIterator<Object> listIterator = Arrays.asList(objArray).listIterator(objArray.length);
while (listIterator.hasPrevious()) {
    Object object = listIterator.previous();
    System.out.println(object.toString());
}