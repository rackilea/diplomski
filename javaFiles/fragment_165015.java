class Parent{
    public void throwException(){
        System.out.println("Didn't throw");
    }
}
class Child extends Parent{
    @Override
    public void throwException(){
        try{
            throw new ArithmeticException("Some arithmetic fail");
        }catch(ArithmeticException ae){
            throw new RuntimeException(ae.getMessage(), ae);
        }
    }
}