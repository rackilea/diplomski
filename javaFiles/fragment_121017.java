public static void main1(String[] args) {

    if (args != null) {
        if (args.length == 2) {
            if (!args[0].equals(args[1])) {
                System.out.println("Args are ok");
            }
        }
    }
}