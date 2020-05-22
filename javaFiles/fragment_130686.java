class Main
{
    public static void main(String[] args)//String[] args, not String args[]
    {
        if (args.length == 0)
        {//check to see if we received arguments
            System.out.println("No arguments");
            return;
        }
        if ( args.length < 3)
        {//and make sure that there are enough args to continue
            System.out.println("To few arguments");
            return;
        }
        try
        {//this try-catch block can be left out
            String phonecode = args[0];//first arg
            String keyword = args[1];//second
            String location = args[2];//third
            //print out the values
            System.out.print("Phonecode: ");
            System.out.println(phonecode);
            System.out.print("keyword: ");
            System.out.println(keyword);
            System.out.print("location: ");
            System.out.println(location);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());//get the exception MESSAGE
        }
    }
}