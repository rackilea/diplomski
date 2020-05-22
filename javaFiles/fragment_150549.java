class Tester extends C implements A, B
{
    @Override public void doWork(){
        A.super.doWork();  //Invoke A's implementation
        B.super.doWork();  //Invoke B's implementation
        super.doWork();    //Invoke C's implementation
    }
}