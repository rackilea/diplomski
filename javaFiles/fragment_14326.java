class MiniHeap<T> {
   private ArrayList<T> pq;

   public MiniHeap(int initialAmount) {
       pq = new ArrayList<>(initialAmount);
   }

   public void insert(Element<T> element) {
       pq.add(element.getKey(), element.getData());
   }
}