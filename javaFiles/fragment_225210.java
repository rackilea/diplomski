class Outer{
    class Inner{
        void test(){
            System.out.println(this$0);//this will not compile
        }
    }
}