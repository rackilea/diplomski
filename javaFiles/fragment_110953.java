Scanner input = new Scanner(System.in);
System.out.println("Enter how many string to get");
int size;
size = input.nextInt();

input.nextLine();//get the new line character and ignore it

String arr[] = new String[size];

System.out.println("Enter strings one by one");
for(int i = 0; i < size; i++) {
    arr[i] = input.nextLine(); 
    System.out.println(i);
}