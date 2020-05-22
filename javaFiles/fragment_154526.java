List myList=new ArrayList();
//modCount for the list is 0

myList.add("test");
//modCount for the list is 1

Iterator iterator=myList.iterator();
//modCount for the list is 1
//expected modCount for the iterator is initialized to 1

myList.add("test 2");
//modCount for the list is 2
//expected modCount for the iterator is initialized to 1

iterator.remove("test");
//modCount != expectedModCount => throw new ConcurrentModificationException()