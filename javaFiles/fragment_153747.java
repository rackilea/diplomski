public static void main(String [] args) throws FileNotFoundException   
{  

 Scanner in = new Scanner (System.in);
 System.out.println("Enter 1 for max index value.\nEnter 2 for min index   value.\nEnter 3 to search for an index value.\n"
        + "Enter 4 for display all index's\nEnter 5 for numbers in a range.\nEnter 6 to exit menu. ");

 int number = in.nextInt();
 int arr[] = new int [200];//change this according to the requirement
 if(number==6){
    System.out.println("Thank you for being awesome");
}

if (number==5){
  reader(arr); 
 System.out.println(minnimum(arr)); 
 }
}