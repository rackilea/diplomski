public class testPolymophism {

    public static void main (String[] args){
        animal a = new dog();
        animal b = new cat();
        a.call();
        b.call();
    }
}

class animal{

    public void call(){
        System.out.println("Specific to what animal is.");
    }
}

class dog extends animal{
    public void call(){
        System.out.println("Bark!");
    }
}
class cat extends animal {
    public void call(){
        System.out.println("Mia~");
    }
}