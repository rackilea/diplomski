public void addUser()
{
    System.out.println("-----------------------------"); //separation of previous screen
    System.out.println("Create a new user.");

    boolean userExists = false;
    boolean isEmail = false;

    do
    {
        userExists = false;
        isEmail = false;

        System.out.print("Username: ");
        String userToAdd = input.next();

        Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher m = p.matcher(userToAdd);
        isEmail = m.matches();

        if (!isEmail) 
        {
            System.out.println("Not an email. Try again.");
        }
        for(User currentUser : db.getUsers()) 
        {
            if (currentUser.getName().equals(userToAdd)) 
            {
                System.out.println("User already exist. Try again.");
                userExists = true;
                break;
            }
        }

    }while(userExists || !isEmail);
}