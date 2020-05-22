public class Test1 {

 String text;
    public Test1(){

       }
    public Test1(String s){
        this.text = s;
        }
    public static void main(String[] args) {
        Test1 test = new Test1("ABC");
        System.out.println(test.text);
    }
}