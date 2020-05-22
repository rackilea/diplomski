Node aNode = new Node ("A", null);
 Node list = new Node ("C", aNode);
 // creates list ("C") -> aNode ("A") -> null

 DynamicList dynamicList = new DynamicList();
 dynamicList.insertFirst(list);
 // dynamicList = list ("C") -> aNode ("A") -> null
 dynamicList.insertAfter(list, "B");
 // dynamicList = list ("C") -> "B" -> aNode ("A") -> null