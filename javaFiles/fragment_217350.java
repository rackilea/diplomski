public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);



    //Port obj = new Port();
    int count, i;
    String b ;

    System.out.println("Enter the number of students");
    count= sc.nextInt();

    int[] age = new int[count];
    String[]  name = new String[count];
    String[] country=new String[count];
    for (i = 0; i < count; i++) {
        System.out.println("Enter the students " + i+1 + " details");
        System.out.println("Your age?");

        age[i] = sc.nextInt();

        sc.nextLine();
        System.out.println("Your name?");

        name[i] = sc.nextLine();
        System.out.println("Is the student from same country[Y/N]");
        b = sc.nextLine();

        // if(b=="N")
        if (b.equals("N")) {
            System.out.println("Enter the country");
             country[i] = sc.next();

        }
        //if(b=="Y")
        if (b.equals("Y")) {
             country[i] = "India";
        }
    }
   String frmt= String.format("%-15s%-15s%-15s","Age","name","country");
    System.out.println("The student details are");
    System.out.println(frmt);
    for( i=0;i<age.length;i++){

        System.out.printf("%d  %15s  %14s",age[i],name[i],country[i]);
        System.out.println();
    }
}

}