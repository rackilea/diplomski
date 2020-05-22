public static void main(final String[] args) {
    if (args.length < 2)
        throw new IllegalStateException("Not enough arguments");
    String year = args[0];
    String[] months = new String[args.length - 1];
    System.arraycopy(args, 1, months, 0, months.length);
    ...
}