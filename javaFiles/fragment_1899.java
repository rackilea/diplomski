DbCall dbCall = mock(DbCall.class);
List<Element> list = Arrays.asList(newElement(1), newElement(2), newElement(3));

runDeleteMethod(list);

InOrder inorder = inOrder(dbCall);
inorder.verify(dbCall).delete(1);
inorder.verify(dbCall).delete(2);
inorder.verify(dbCall).delete(3);