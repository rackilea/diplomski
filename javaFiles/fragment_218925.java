public static void main(String[] args) {
    // TODO code application logic here
    Scanner sc = new Scanner(System.in);
    int dane = -1 ;

     boolean keepLooping = true;   //if you delete this works the same with same problem
while(keepLooping && dane != 0)  
{    

    System.out.println("Pick a number:");
try
{ 

        dane = Integer.parseInt(sc.next());


}catch (NumberFormatException e)
  {
       keepLooping = true;
  }  
System.out.println("Out from exception");

}