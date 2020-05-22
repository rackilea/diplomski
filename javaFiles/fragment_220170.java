public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Scanner fc;
    if (args.length != 0) {
        fc = new Scanner(new File(args[0]));
    } else {
        fc = new Scanner(new File("path_here"));
    }
   ....
}