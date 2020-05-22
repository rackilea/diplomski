boolean stop = false;
while(!stop) {
    //do whatever you want here

    System.out.println("Do you want to quit?(yes or no");
    String input = scan.nextLine();
    if(input.equals("no")) {
        stop = true;
    }
}