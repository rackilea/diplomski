public static void main (String [] args) throws FileNotFoundException
{
    Directory dir= new Directory();

    System.out.print("Please enter the file name: ");
    fileName = kb.nextLine();
    fileName = fileName + ".txt";
    inFile = new File(fileName);
    in = new Scanner(inFile);
    dir.loadData(in);
    showMenu();

    System.out.println();

    selection = '\0';
    while(selection != 'E')
    {
        System.out.print("Please choose one of choices: ");
        choice = kb.next();

        selection = choice.toUpperCase().charAt(0);

        switch(selection)
        {
            case 'P':
                dir.printDirectory();
                break;
            case 'L':   
                System.out.println("Search!");
                break;
            //some codes here for selection process 
        }
    }

    System.out.println ("Thank you!");
}