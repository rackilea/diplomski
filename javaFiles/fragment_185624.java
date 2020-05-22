class B{
    private static int x;
    public B(int x){
        B.x = x;
    }

    public int getX() {
        return x;
    }
}

public class Helper {

    public static void main(String[] args) {
        B bOne = new B(44);
        System.out.println(bOne.getX());

        B bTwo = new B(88);
        System.out.println(bTwo.getX());
        System.out.println(bOne.getX());

    }
}