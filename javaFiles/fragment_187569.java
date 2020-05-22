List<String> vNames = new ArrayList();
List<String> bNames = new ArrayList();

if (choys == 1)
{
    ch = new Scanner(System.in);
    System.out.println("Enter name: ");
    userBName = ch.nextLine();

    System.out.println("Enter age: ");
    userBAge = ch.nextInt();

    if(userBAge >=18 && userBAge <=21)
    {
        System.out.println("Congrats "+userBName+"! Welcome to the team.");
        bslot++;
        bNames.add(userBName);
    }
 }

if (choys == 2)
{
    ch = new Scanner(System.in);
    System.out.println("Enter name: ");
    userVName = ch.nextLine();

    System.out.println("Enter age: ");
    userVAge = ch.nextInt();

    if(userVAge >=18 && userVAge <=21)
    {
        System.out.println("Congrats "+userVName+"! Welcome to the team.");
        vSlot++;
        vNames.add(userVName);
    }
 }
 if (choys == 3)
{
    System.out.println("Current number of recruits:\n");
    System.out.println("Basketball team: ");
    for(String name:bNames){
        System.out.println("Username : "+ name);
    }

}