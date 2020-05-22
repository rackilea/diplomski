class TestClass {

     static int testInt = 0 ;

     public static setTestInt ( int a ) {
          TestClass.testInt = a ;
     }

     public void setInt ( int a1 ) {
          setTestInt ( a1 ); 
     }
}