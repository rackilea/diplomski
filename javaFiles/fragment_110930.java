String Name;
Scanner input = new Scanner(System.in);

System.out.print("Enter name:");
Name = input.nextLine();
// use: System.out.println("name:");
//      System.out.println(Name);
System.out.printf("%-20s %n", "Name:" , Name);