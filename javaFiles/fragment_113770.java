public class Dubious
{
   static private List<Class<? extends Exception>> types = 
           Arrays.asList( Exception.class, FileNotFoundException.class,
                   IOException.class, IllegalArgumentException.class,
                   RuntimeException.class );

   public static void main(String[] args) {
      processException( new InvalidKeyException() );
      processException( new SocketException() );
      processException( new IllegalArgumentException() );
      processException( new Exception() );
   }

   public static void processException( Exception ex ) {
      Class<?> exType = ex.getClass();
      while( !types.contains( exType ) ) 
         exType = exType.getSuperclass();
      System.out.println( exType );
   }
}