class Element<T> {
   private int key;
   private T data;

   public Element(int key, T data) {
       this.key = key;
       this.data = data;
   }

   public T getData() {
       return data;
   }

   public int getKey() {
       return key;
   }
}