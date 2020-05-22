public static void main(String[] args) throws IOException {
    if(args == null || args.length != 2) {
        System.out.println("You have not entered the required two parameters");
        return;
    }
    try {
        int x = Integer.parseInt(args[0]);
        process(x, args[1]);
    } catch (NumberFormatException e) {
        System.out.println("Please enter an integer");
    }


}