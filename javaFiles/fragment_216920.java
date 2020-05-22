package a.b.c;


public class EnumsTest {

  public enum A {
    A1( B.class ),
    A2( C.class );

    private final Class<? extends Enum<?>> enumClazz;

    A( final Class<? extends Enum<?>> enumClazz  ) {
      this.enumClazz = enumClazz;
    }

    public Enum<?>[] getSubEnumConstants() {
      return enumClazz.getEnumConstants();
    }

   /**
    * @param value
    * @return Never null
    * @throws IllegalArgumentException To be consistent with Enum.valueOf()
    */
   public <T> Enum<?> valueOfSubEnum( final String value ) throws IllegalArgumentException {
     for( Enum<?> enumInstance : getSubEnumConstants() ) {
       if( enumInstance.name().equals( value ) ) {
         return enumInstance;
       }
     }
     throw new IllegalArgumentException( "valueOf for " + enumClazz.getName() + " could not be resoled with the value of " + value );
   }

  }

  public enum B {
    B1,
    B2;
  }

  public enum C {
    C1,
    C2;
  }

  public static void main( String[] args ) {

    for( A a : A.values() ) {
      for( Enum<?> enumInstance : a.getSubEnumConstants() ) {
        System.out.println( a.name() + ":" +  enumInstance.name() );  
      }
    }
    Enum<?> valueOfSubEnum = A.A1.valueOfSubEnum( "B2" );
    System.out.println( valueOfSubEnum.name() );
  }
}