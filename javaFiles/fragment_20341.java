class Test{
    CharSequence show(){
        System.out.println("1");
        return null;
    }
}
class xyz extends Test{
    String show(){
        System.out.println("2");
        return null;
    }
}