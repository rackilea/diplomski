int hash = searchKey % arr.length;
MyList newNode = new MyList(searchKey);
MyList arrIndex = arr[hash];

if (arrIndex == null) {
  arr[hash] = newNode;
} else {
  while (arrIndex.next != null) { 
    arrIndex = arrIndex.next;
  }
  arrIndex.next = newNode;
}