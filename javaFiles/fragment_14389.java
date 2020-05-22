private int findIdx(int item) {
  // search for item in the hashtable
  // the item was found at array index 'idx'
  return idx;
} 

public Node lookup(int item) {
  return tbl[findIdx(item)];
}   

public int remove (int item) {
  tbl[findIdx(item)] = null;
}