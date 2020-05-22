if(PWD.length()>=6)
      {
        System.out.println("Password is greater than 6 char" );
        if(UpperCasePresence(PWD))
        {
            System.out.println("Password has Upper case letter" );

            if(LowerCasePresence(PWD))
            {
                System.out.println("Password has Lower case letter" );
                if(SpecialCharPresence(PWD))
                {
                    System.out.println("Password has Special Character" );
                    if(NumberPresence(PWD))
                    {
                        System.out.println("Password has Number" );
                        System.out.println("Password Matches all Conditions");
                    }
                    else
                    {
                        System.out.println("Password doesnot have Number" );
                    }


                }
                else
                {
                    System.out.println("Password doesnot have Special Characters");
                }
            }
            else
            {
                System.out.println("Password doesnot have Lower Case Letters");
            }
        }
        else
        {
            System.out.println("Password doesnot have Upper Case Letters");
        }
    }
    else
    {
        System.out.println("Password Length is" + PWD.length() );
    }