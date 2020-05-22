public static void main(String[] args) {
    ...

    List<String> process_args = new ArrayList<String>(Arrays.asList("cmd", "/c", "python", "ps.py"));
    process_args.addAll(Arrays.asList(args));

    Runtime r = Runtime.getRuntime();
    try {

        Process p = r.exec(process_args.toArray(new String[] {}));
        ...
    } catch (IOException e) {
        ...
    }
}