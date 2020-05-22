final List<Integer> list = spy(List.class);

... act...

final InOrder inOrder = inOrder(list, mockDependency);

inOrder.verify(list).add(1);
inOrder.verify(mockDependency).handleList(list);
inOrder.verify(list).clear();
inOrder.verify(mockDependency).handleList(list);
inOrder.verify(list).add(2);