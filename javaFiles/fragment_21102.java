public static void main(String[] args) throws IOException {
    if (args.length != 1) {
        System.out.println("Requires 1 parameter that points to a file.");
        System.exit(1);
    }
    File f = new File(args[0]);
    if (!f.isFile()) {
        System.out.println("Not a file: " + f);
        System.exit(1);
    }
    PasswordEncoder encoder = new BCryptPasswordEncoder();
    try (Stream<String> lines = Files.lines(f.toPath())) {
        lines.map(encoder::encode)
                .forEach(System.out::println);
    }
}