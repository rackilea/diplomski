Doubly iterator = this.getFirstChild();
Doubly newList = iterator.copyNode();
Doubly newListTail = newList;

Doubly deepCurrNode = null
while ((iterator = iterator.getNext()) != null)
{
     deepCurrNode = iterator.copyNode();
     newListTail.setNext(deepCurrNode);
     deepCurrNode.setPrevious(newListTail);
     newListTail = deepCurrNode;
}
//just in case these aren't already null, I'll be explicit
newList.setPrevious(null);
newListTail.setNext(null); 
return newList;