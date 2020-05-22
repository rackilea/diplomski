public static void main(String[] args) 
{
    Scanner kb = new Scanner(System.in);
    String[]namearray;                       //Setting up the arrays
    namearray = new String[1000];            //Assume there are not 1000+ people
    double[]hrs_worked;
    hrs_worked = new double[1000];
    double[]payarray;
    payarray = new double[1000];
    int[]dependarray;
    dependarray = new int[1000];

    String name = "";                            //Initialize input
    float hrs;
    double pay;
    int dependents;
    int Q = -1;

    while( true)
    {
        if(Q>-1)
        {
            System.out.println("\nPlease input the employee name or press enter to end the process:");
            name = kb.nextLine();

        }
        else
            System.out.println("Please input the employee name:"); //Collect employee info

        name = kb.nextLine();
        if(name==null || name.trim().equals("")) break;

        System.out.println("Please input the hours the employee worked:");
        hrs = kb.nextFloat();
        System.out.println("Please input the employee's hourly pay:");
        pay = kb.nextDouble();
        System.out.println("Please input the number of dependents the employee"
                + " claims:");
        dependents = kb.nextInt();
        Q++;

        namearray[Q] = name;
        payarray[Q] = pay;   
        hrs_worked[Q] = hrs;
        dependarray[Q] = dependents;
    }
}