public void run() 
{
    while(true) 
    {
        if (inputReader.hasNext())
        {
            String input = inputReader.next();
            if (input.equals("["))
            {
                rand+=100;
                System.out.println("Pressed [");
            }
            if (input.equals("]"))
            {
               rand-=100;
               System.out.println("Pressed ]");
            }
            if (input.equalsIgnoreCase("Q"))
            {
                break; // stop KeyPressThread
            }
        }
    }
}