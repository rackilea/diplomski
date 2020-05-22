public class CoPrimetest {

    @Test
    public void testing() { 
       CoprimeNumbersTest instance = new CoprimeNumbersTest();
       boolean result = instance.isCoprime( 1, 1 );
       boolean expected = true;
       assertEquals( expected, result );
    }
}