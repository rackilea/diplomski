public int[] removeElement(int[] original, int element){
    int[] n = new int[original.length - 1];
    System.arraycopy(original, 0, n, 0, element ); // can be replaced by a loop
    System.arraycopy(original, element+1, n, element, original.length - element-1);
    return n;
}