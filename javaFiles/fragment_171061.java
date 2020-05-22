while(in.hasNext()) {
    String input = in.nextLine();
    if(input.equals("Yes") || input.equals("Start") || input.equals("Turn on")) {
        System.out.println("Engine is on!");
        break;
    } else {
        System.out.println("Your input is not correct! Please start the engine!");
    }
}