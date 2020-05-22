@Override
   public int hashCode() {
      int hash = 3;
      hash = 47 * hash + this.source;
      hash = 47 * hash + this.target;
      return hash;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (getClass() != obj.getClass()) {
         return false;
      }
      final Pair other = (Pair) obj;
      if (this.source != other.source) {
         return false;
      }
      if (this.target != other.target) {
         return false;
      }
      return true;
   }