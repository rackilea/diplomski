// returns exit flag
public bool choose(int choice){
    switch(choice){
        case 1:
            System.out.println("hi");
            return false;
        case 2:
            return true;
    }
}

// print instructions and return the choose
public int printInstructions(){
    System.out.println("check 1 to print hi");
    System.out.println("check 2 to exit");
    Scanner scanner=new Scanner(System.in);
    int choice=scanner.nextInt();
    scanner.nextLine();
    return choice;
}


public Admin(){
    while (!exit){
      int result = printInstructions();
      exit = choose(result);
    }
}