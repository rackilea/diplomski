public class TC1 {

    public static void main(String[] args){
        String name, age, answer;
        Scanner IN = new Scanner (System.in);
        System.out.println("Whats yor name?");
        name = IN.next();
        System.out.println("How old are you?");
        age = IN.next();
        answer = age + name;
        System.out.println(answer);
    }
}