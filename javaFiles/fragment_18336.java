protected void upHeap(int j) {
  if (j <= 1) //this handles the condition of the original while loop
    return;
  int p = parent(j);
  if (compare(heap.get(j), heap.get(p)) >= 1) 
    return; // this handles the break from the while loop
  swap(j, p);
  upHeap(p); // the recursive method call, replacing j with p
}