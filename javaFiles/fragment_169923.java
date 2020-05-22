InputStreamReader ist=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(ist);
    List l = new List();
    int input;

    while(true)
    {
        System.out.println("Enter a the corresponding number to select the menu and then press enter");
        System.out.println("1. Enter values and traverse them");
        System.out.println("2. Enter a value and find it in the list");
        System.out.println("3. Enter a range to be extracted from the list");
        System.out.println("4. Exit?");
        input=Integer.parseInt(br.readLine());

        if(input<5 && input>0)
        {
            switch(input)
            {
                case 1: get_values();
                        break;
                case 2: extract();
                        break;
                case 3: sublist();
                        break;
                case 4: System.out.println("Goodbye");
                        System.exit(0);
                        break;
            }
        }
    }