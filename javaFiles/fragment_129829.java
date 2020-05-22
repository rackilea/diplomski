public class Calculator {
    public static void main(String[] args){

        System.out.println("Type in any 2 numbers: ");
        Scanner math = new Scanner(System.in);
        int number = math.nextInt();
        int num2 = math.nextInt();

        System.out.println("Which operation would you like to use? (+,-,*,/)");
        String oper = math.next();

        if (oper.equals("+")){
            int total = number + num2;
            System.out.println(total);
        }
        else if (oper.equals("-")){
            int total = number - num2;
            System.out.println(total);
        }
        else if (oper.equals("*")){
            int total = number * num2;
            System.out.println(total);
        }
        else if (oper.equals("/")){
            int total = number / num2;
            System.out.println(total);
        }
    }