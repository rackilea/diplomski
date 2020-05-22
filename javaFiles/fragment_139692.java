private void CheckPassword()
{
    String[] commonPass = new String[4];
    commonPass[0] = "testing";
    commonPass[1] = "stackoverflow";
    commonPass[2] = "coding";
    commonPass[3] = "userinput";

    Scanner s = new Scanner(System.in);

    System.out.println("Enter your password.");
    String password = s.nextLine();

    for(int i = 0; i < commonPass.length; i++) 
    {
        if (password.contains(commonPass[i])) 
        {
            CheckPassword();
        }
    }       

}