public class Test{

    public Test(){
        B b=new B();
        C c=new C();


        for(int i=0;i<10000;i++){
            testUsingInstanceOf(b);
            testUsingInstanceOf(c);
            testUsingException(b);
            testUsingException(c);
        }
    }

    public static void main(String[] args){

        Test test=new Test();

    }

    public static boolean testUsingInstanceOf(A possiblyB){
        if (possiblyB instanceof B){
            return true;
        }else{
            return false;
        }
    }
    public static boolean testUsingException(A possiblyB){
        try{
            B b=(B)possiblyB;
            return true;
        }catch(Exception e){
            return false;
        }
    }


    private class A{

    }
    private class B extends A{

    }
    private class C extends A{

    }        
}