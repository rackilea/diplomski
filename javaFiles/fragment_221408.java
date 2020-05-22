HashMapHistogramComparator<T> implements Comparator<HashMap.Entry<T,Integer>> {
  HashMapHistogram<T> hshMp;

  public HashMapHistogramComparator(HashMapHistogram<T> hshMp){
    this.hshMp = hshMp;
  }

  @Override
  public int compare(HashMap.Entry<T,Integer> arg0, HashMap.Entry<T,Integer> arg1) {
    int val1 = arg0.getValue();
    int val2 = arg1.getValue();
    return Integer.compare(val2,val1);
  }
 }