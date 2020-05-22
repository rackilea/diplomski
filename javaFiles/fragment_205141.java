public class Main {
    public static void main(String[] args) {
        SubB var = (SubB) someMethod();         
    }

    private static Super someMethod(){
        return new SubA();
    }
}

class Super { }
class SubA extends Super { }
class SubB extends Super { }