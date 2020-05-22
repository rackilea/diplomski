ArrayList<String> list = new ArrayList<String>();
list.add("test");
Iterator listIterator = list.listIterator()
while(listIterator.hasNext()) {
        System.out.println(listIterator.next());
}