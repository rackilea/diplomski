String baseString = "nullpointer";
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    if(baseString.length()!=input.length()){
        System.out.println("false");
    }
    else{
        if(baseString.concat(baseString).contains(input)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }