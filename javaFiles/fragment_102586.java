public static void main(String[] args) {
    String input = findArg("input", args);
    String output = findArg("output", args);
}

static String findArg(String name, String[] args) {
    for (int i = 0; i < args.length; i += 2) {
        if (args[i].equals("-" + name)) {
            return args[i + 1];
        }
    }
    return null;
}