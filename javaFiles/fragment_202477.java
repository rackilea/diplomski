String[][] empDetString= new String[2][10];
String input;
int i;

System.out.println("Enter emp details: ");

for (i=0; i<empDetString.length; i++){
  empDetString[i]=sc.nextLine().split("#");
}