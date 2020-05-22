boolean bool = true;
do {
    Scanner kb = new Scanner(System.in);
    String choice = kb.next();
    if(choice.equals("Hit") || choice.equals("hit")) {
        String action = "hit";
        bool = false;
    } else if(choice.equals("Stay") || choice.equals("stay")) {
        String action = "stay";
        bool = false;
    } else {
        System.out.println("Do not recognize response. Retry.");
    }
} while (bool == true);