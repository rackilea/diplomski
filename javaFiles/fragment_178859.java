public void act()
{

    String letterh = "h";
    String letteri = "i";
    String keyPress1 = Greenfoot.getKey();
    String keyPress2 = Greenfoot.getKey();
    if (keyPress1 != null) 
    {
        if(keyPress1.equals(letterh))
        {
           Called.call1();

        }

    }

    if (keyPress2 != null) 
    {
       if(keyPress2.equals(letteri))
        {
            Called.call2();
        }
        else
        {
            System.out.println("Not same");
        }       

    }
}