FindIterable iterable = mock(FindIterable.class);
MongoCursor cursor = mock(MongoCursor.class);

Document doc1= //create dummy document;
Document doc2= //create dummy document;

when(collection.find(dbObj)).thenReturn(iterable);

when(iterable.iterator()).thenReturn(cursor);
when(cursor.hasNext()) 
  .thenReturn(true)
  .thenReturn(true)// do this as many times as you want your loop to traverse
 .thenReturn(false); // Make sure you return false at the end.
when(cursor.next())
  .thenReturn(doc1)
  .thenReturn(doc2);