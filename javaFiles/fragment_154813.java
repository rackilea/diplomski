public static void main(String[] args) {
Scanner input = new Scanner(System.in);

    String[] Name = new String[20];
    String[] Mobile = new String[20];
    char[] Blood_Gp = new char[20];
    int[] Count_o_Donation = new int[20];
    int[] Blood_Stock = new int[20];
    int index = 0;

    while (true){
        displayMainMenu();
    readAndVerify();
    String choice = readAndVerify();

        switch (choice){
            case "1":
                addDonor(Name, Mobile, Blood_Gp, Count_o_Donation, Blood_Stock, index);
                index++
                break;
        }
       if (choice.equals("e")) 
           break;
    }


    System.out.println(Name[0]);
    System.out.println(Name[1]);

}

   public static void addDonor(String[] a1, String[] a2, char[] a3, int[] a4, int [] a5), int index{
Scanner input = new Scanner(System.in);


System.out.print("  Enter the name (first and last):" + " ");
String name = input.nextLine();
System.out.print("  Enter Mobile No.:" + " ");
String phone = input.next();

if (phone.length() < 10 && phone.startsWith("0") == false){
    while (true){
        System.out.println("Wrong Mobile NO... try again!");
        System.out.print("  Enter Mobile No.:" + " ");
        phone = input.next();
        if (phone.length() > 10 || phone.startsWith("0") == true)
            break;
    }
}

System.out.print("  Enter Blood Group Type (A, B or O):" + " ");
char blood =  input.next().charAt(0);

    while (blood != 'a' || blood != 'b' || blood != 'c'){
        System.out.println("Wrong Blood Group Type... try again!");
        System.out.println("    Enter Blood Group Type (A, B or O):" + " ");
        blood =  input.next().charAt(0);
        if (blood == 'A' || blood == 'B' || blood == 'O')
            break;    
    }

    a1[index] = name;
    a2[index] = phone;
    a3[index] = blood;
    a4[index] = 1;
    a5[index] = 1;