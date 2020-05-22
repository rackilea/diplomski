String [] choices = { "enter name:","enter age:","enter gender:"};
    String ctr1[];

    Scanner scan = new Scanner(System.in);
    System.out.print("Enter How Many Inputs: ");
    int num1 = Integer.parseInt(scan.nextLine());
    ctr1 = new String[num1];

    for (int i = 0; i < num1; i++) {
        System.out.println(choices[i]);
        ctr1[i] = scan.nextLine();
    }

    for(int i = 0; i < ctr1.length; i++)
    {
        if(i == 0)
            System.out.println("Name: "+ ctr1[i]);
        else if( i == 1)
            System.out.println("Age: "+ ctr1[i]);
        else if( i == 2)
            System.out.println("Gender: "+ ctr1[i]);
    }