public class ThisExampleMain {
    public static void main(String[] args) {
        ThisExample ts = new ThisExample(50, 50);
        //you want this to be 50 but it ends up being 0:
        System.out.println("Wrong: " + ts.getWrongExample());
        //this returns the correct answer:
        System.out.println("Right: " + ts.getThisExample());
    }
}