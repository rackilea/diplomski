public enum Constants {
    ACCOUNT,
    EVENT_ITEM,
    ;

}

public enum Operation {
   MULTIPLIER_ONE {
        public int action(int value) {
            return value;
        }
   },
   MULTIPLIER_NEGATIVE_ONE {
        public int action(int value) {
            return value * (-1);
        }
   },
   ;
   private Operation(int coef) {
        this.coef = coef;
   }

   public abstract int action(int value);
}