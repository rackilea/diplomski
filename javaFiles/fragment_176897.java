int flag = 0;
    while(flag != -1) {
        switch(Userinput) {
            case "A": 
                System.out.println("Fido is "+Pet1.GetAge()+ " years old and is " + Pet1.Getadoptionstatus());
                System.out.println("furball is " + Pet2.GetAge()+ " years old and is " + Pet2.Getadoptionstatus());
                Userinput=scan.nextLine();
                break;
            case "B":
                System.out.println("Everyone just got a little older.");
                Pet1.ageincrease();//Still keeps Pet1 age to 3
                Pet2.ageincrease();//Still keeps Pet2 age to 1
                System.out.println(Pet1.GetAge() + " " + Pet2.GetAge());
                Userinput=scan.nextLine();
                break;
            case "C":
                System.out.println("Please type in a name");
                Pet3name=scan.nextLine();
                System.out.println("Please type in an age");
                Pet3age=scan.nextInt();
                Userinput=scan.nextLine();
                break;
            case "D":
                //Not sure how you want to implement this
                break;
            case "E":
                flag = -1;
                break;
            }
    }