public abstract class Value {
   protected int value;
   protected abstract List<Integer> getPossibleValues();

   public Value(int val) {
       if (!getPossibleValues().contains(val))
           throw new IllegalArgumentException("Illegal value");
       value = val;
   }
}