public class InputLogic {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        User users[];

        System.out.println("How many name you want to enter:");
        int num = sc.nextInt();
        users = new User[num];

        for (int i=0; i<num; i++) {
            users[i] = new User();
            System.out.println(i + " Enter First name:");
            String temp = sc.nextLine();
            users[i].setFirst_Name(temp);
            System.out.println(i + " Enter Last name:");
            temp = sc.nextLine();
            users[i].setLast_Name(temp);
        }
    } 
}