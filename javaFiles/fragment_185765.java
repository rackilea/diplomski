Library library = new Library();
Book obj = Mockito.mock(Book.class);

Mockito.when(obj.getPages()).thenReturn(1); // return 1 or whatever value you want

int x = library.methodA(obj);