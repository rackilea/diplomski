public class TestSO {
    private class InnerClassA {

    void test(){    
     InnerClassB innerClassB= new InnerClassB();
     innerClassB.someMethodInB();
    }
     }

     private class InnerClassB {

          void someMethodInB(){}
     }
     }