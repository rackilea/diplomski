public class ExampleClass
{
   public static final int INVALID_VALUE = -1;

   public static void main(final String[] args)
   {       
      final InterfaceA< Integer > iaObject = new InterfaceA< Integer >() {
         @Override
         public Integer doStuff( String paramA, Holder<Integer> holder ) {
            return holder.value = paramA.length();
         }
      };

      final ClassA<Integer> objA = new ClassA<>( iaObject );
      int result = objA.doStuff("hello, world", new Holder<>( INVALID_VALUE ));
      if( result == INVALID_VALUE ) {
         System.err.println("Invalid length !");
      }
      else {
         System.err.println("The length is : " + Integer.toString( result ));
      }
   }

   public static class ClassA<T> {
      private final InterfaceA<T> iaObject;

      public ClassA( final InterfaceA<T> iaObject_ ) {
         this.iaObject = iaObject_;
      }

      public T doStuff( final String paramA, Holder<T> holder ) {
         return this.iaObject.doStuff( paramA, holder );
      }
   }

   public static interface InterfaceA<T> {
      public T doStuff( String paramA, Holder<T> resultHolder );
   }

   public static class Holder<T> {

      public T value;

      public Holder( T value_ ) {
         value = value_;
      }
   }
}