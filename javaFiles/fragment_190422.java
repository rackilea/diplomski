public class Test {
   private final ReadOnlyIntegerWrapper foo = new ReadOnlyIntegerWrapper();

   public Test() {
        foo.set(42);
   }

   public final javafx.beans.property.ReadOnlyIntegerProperty fooProperty() {
       return this.foo.getReadOnlyProperty();
    }   


   public final int getFoo() {
      return this.fooProperty().get();
  }
}