Scanner sc= new Scanner(System.in);
System.out.println("Please choose your table from 1-20.");

int table;
int x = 1;

do{
  table = sc.nextInt(); // every time the user will input the number
  if(table >0 && table <21){
    System.out.println("Table chosen: " + table);
    x=2;
  }
  else{
    System.out.println("Wrong choice");
  }
}while(x==1);