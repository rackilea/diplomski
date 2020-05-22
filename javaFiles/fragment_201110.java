class counterTest{
    public static int count;
    public counterTest(){
        count++;
    }

    protected void finalize(){
        System.out.println("Program about to terminate");
        counterTest.count--;
        System.out.println("Number of objects :" + counterTest.count);
    }
}

public class Finalize {

    public static void main(String args[]){

        counterTest obj1=new counterTest();
        System.out.println("Number of objects :" + counterTest.count);
        counterTest obj2=new counterTest();
        System.out.println("Number of objects :" + counterTest.count);
        Runtime rs=Runtime.getRuntime();
        obj1=null;
        obj2=null;
        rs.gc();
    }

}