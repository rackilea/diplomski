public static void main (String[] args) throws java.lang.Exception
{
    Scanner input = new Scanner(System.in);
    String s1;
    System.out.println("Enter a phrase: ");
    s1=input.nextLine();
    s1=s1.trim();
    int counter;
    char c;
    boolean flag=true;

    for(counter=0; counter < s1.length(); counter++)
    {
        c=s1.charAt(counter);
        if(flag==true)
        {
            c = Character.toUpperCase(c);
            flag=false;
        }
        else if(s1.charAt(counter)==' ')
        {
            flag=true;
        }
        System.out.print(c);
    }
}