public class Main {

    public static void main(String[] args) {
        ArrayList<Abc> foo = new ArrayList<>();
        xyz(foo);
    }

    private static <T extends B> void xyz(ArrayList<T> abs){
        System.out.print("running xyz");
    }


    private static abstract class  A{}
    private static abstract class  B extends A{}
    private static abstract class  C extends A{}
    private static class Abc extends B{}
}