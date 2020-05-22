public int getMinimum() throws Exception {
  if (isEmpty())
      throw new Exception("Heap is Empty");
  else
      return data[0];
}