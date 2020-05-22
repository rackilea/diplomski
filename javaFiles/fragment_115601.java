public static void main(String[] args)
{
    CollegeTester ct = new CollegeTester();
    ct.getCommand();//goes to command

}  

//Ask user for a command
public void getCommand()
{
    boolean exit = false;
    while(!exit){
        String command = "";
        System.out.println("Enter a command: ");
        command = input.nextLine();
            if(command.equals("add")){
                addCommand();//If command is add go to addCommand
            }else if(command.equals("course")){
                courseCommand();//If command is course go to courseCommand
            }else if(command.equals("find")){
                findCommand();
            }else if(command.equals("remove")){
                removeCommand();
            }else if(command.equals("highest")){
                highestCommand();
            }else if(command.equals("login")){
                loginCommand();
            }else if(command.equals("quit")){
                exit = true;
            }else {
                System.out.println("Not valid command, try again.");
            }
    }

}



//Ask user for a command
public void getCommand()
{
    while(true){
        String command = "";
        System.out.println("Enter a command: ");
        command = input.nextLine();
            if(command.equals("add"))
                addCommand();//If command is add go to addCommand
            if(command.equals("course"))
                courseCommand();//If command is course go to courseCommand
            if(command.equals("find"))
                findCommand();
            if(command.equals("remove"))
                removeCommand();
            if(command.equals("highest"))
                highestCommand();
            if(command.equals("login"))
                loginCommand();
            if(command.equals("quit"))
                System.exit(0);  // or could use 'break' here (thanks Mikkel)
    }

}