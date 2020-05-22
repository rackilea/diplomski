class Test{
    CharSequence show(){
        System.out.println("1");
        return null;
    }
}
class xyz extends Test{
    Integer show(){  //won't compile
        System.out.println("2");
        return null;
    }
}