public static void main1(String[] args) {

    if (args != null                // Must have args
        && args.length == 2         // Two of them, to be precise
        && !args[0].equals(args[1]) // And they can't be the same
        ) {
            System.out.println("Args are ok");
    }
}