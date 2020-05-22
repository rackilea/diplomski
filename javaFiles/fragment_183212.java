if (choice == 1){
    System.out.println("how big would you like your array?");
    choice = sc.nextInt();
    Array_1 userArray = new Array_1(choice);
    for (int i = 0; i < choice; i++) {
        userArray.add_data(i,i+1);
    }