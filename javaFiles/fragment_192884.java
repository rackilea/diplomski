Integer[] getSortedEntityIds(Iterator<Element<Integer, Integer>> iter) {
  Comparator<Element<Integer,Integer>> comp = new Comparator<Element<Integer, Integer>>() {
    @Override
    public int compare(Element<Integer,Integer> ela, Element<Integer,Integer> elb) {
      return ela.getPriority().compareTo(elb.getPriority());
    }
  };

  PriorityQueue<Element<Integer,Integer>>pq = new PriorityQueue<Element<Integer,Integer>>(256, comp);
  // If you had the access to the whole list, you wouldn't have to iterate, you could just pass it into the pq constructor
  while(iter.hasNext() {
    pq.add(iter.next());
  }

  Integer[] sortedEntityIds = new Integer[pq.size()]

  for(int i = 0; i < pq.size(), i++) {
    Element<Integer, Integer>el = pq.remove();
    sortedEntityIds[i] = el.getEntityId();
  }

  return sortedEntityIds;
}