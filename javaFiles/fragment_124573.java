public static void main(String[] args) throws FileNotFoundException {
    if (args.length > 1) {
        hasNumInput(args[0], Integer.parseInt(args[1]));
    } else {
        onlyStrInput(args[0]);
    }
}