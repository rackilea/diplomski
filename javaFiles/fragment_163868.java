public class App {
    public static void main(String[] args) {

    try {
        Parent2 par = new Parent2("aa", 5);
        Parent2 par2 = new Parent2(null, 5);
        Parent2 par3 = new Parent2(null, 5);

    System.out.println(par.equals(par2));
    System.out.println(par2.equals(par));
    System.out.println(par3.equals(par2));

    System.out.println("----------------------------------------");

    String str = null;
    String str2 = null;

    System.out.println(str.equals(str2));
    System.out.println(str + "; " + str2);
    } catch (Exception e) {
        //this will do the "trick"
        e.printStacktrace(System.out);
    }
    }
}