public class AhaProgram {

    private static Container container1;

    public static void main(String[] args) {
        Scanner reader = new Scanner (System.in);`
        System.out.println("Hello! This is the AHA Program of Jalosjos,             Parreno and Alfonso");
        System.out.println("Please type the letter of your option");
        boolean loop  = false;

        while (loop != true) {
            showOptions();
            inputHandler();

            String contInput = reader.nextLine();
            if (contInput.equals("1")) {
                System.out.println("Input the name of Container 1: ");
                String ContInp1 = reader.nextLine();
                container1 = new Container(ContInp1);
                container1.printContainer();
            } 

          // ...the rest of your program...
}