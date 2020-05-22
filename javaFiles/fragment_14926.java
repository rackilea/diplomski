Scanner in = new Scanner(System.in);
    while(true){
        System.out.println("Please enter \"stop\" to stop the program.");
        String command = in.nextLine();
        if("stop".equalsIgnoreCase(command)){
            reader.close();
            System.exit(0);
        }
    }