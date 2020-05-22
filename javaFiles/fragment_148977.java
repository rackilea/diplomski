Scanner sc = new Scanner(System.in);
System.out.print("Please enter name of student: ");
String name = sc.nextLine();

for(int i = 0; i < arrayString.length; i++){
    if(name.equals(arrayString[i])) {
        System.out.println(arrayReal[i]);
    }
}