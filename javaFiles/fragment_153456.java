public class Main{
    public static void main (String[] args){
        new Main().start();
    }
    public void start(){
        new OtherClass(this).doSomething();
    }

    public void whatever(){...}
}

public class OtherClass{
    private final Main main; 
    public OtherClass(Main aMain){
        main = aMain;
    }
    public void doSomething{
        main.whatever();
    }
}