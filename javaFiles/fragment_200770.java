public class StringScanner
{
  public static void main(String args[])
  {
    Scanner in = new Scanner(System.in);

    //get the input for number of students:
    System.out.println("Enter The number of students:");
    int totalstudents = in.nextInt();
     in.nextLine();// just to ignore the line
    //store into String array

    String studentname[] = new String[totalstudents];

    for(int i = 0; i < studentname.length;i++)
    {

        System.out.println("Enter Student Names: "+i);
        studentname[i] = in.nextLine();
    }
    for(String names:studentname)
    {
        System.out.println(names);
    }
 }
}