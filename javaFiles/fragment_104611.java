public class Test {
    public static void main(String[] args) {
        try{
            Scanner s = new Scanner(Test.class.getResourceAsStream("/myfile.txt")); // <- in the src folder
            Scanner s2 = new Scanner(Test.class.getResourceAsStream("./myfile.txt")); // <- in the package of your *.java file
            System.out.println(s.next());
            System.out.println(s2.next());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}