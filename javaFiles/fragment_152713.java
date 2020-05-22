class Monomial implements Comparable<Monom> {
   private int exponent;
   private int factor;

   // TODO: get methods, constructor

   public int compareTo(Monomial other) {
       return this.exponent - other.exponent;
   }

   public Monomial times(Monomial other) {
      // here your multiplication code
   }


}