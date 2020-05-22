List list = new LinkedList();
List spy = spy(list);

// Impossible: real method is called so spy.get(0) throws IndexOutOfBoundsException (the list is yet empty)
when(spy.get(0)).thenReturn("foo");

// You have to use doReturn() for stubbing
doReturn("foo").when(spy).get(0);