static Map<Integer, Group> groups = new HashMap<Integer, Group>();

    public static void main(String... args) {
        groups.put(0, new Group(1, "hello")); // (0: -)       -> (1: "hello")
        groups.put(2, new Group(9, "!"));     // (2: "world") -> (9, "!")
        groups.put(3, new Group(5, "bye"));   // (3: -)       -> (5, "bye")
        groups.put(1, new Group(2, "world")); // (1: "hello") -> (2: "world")
        System.out.println(traverse(0));
    }

    private static String traverse(int from) {
        if (!groups.containsKey(from)) return "";

        String path = traverse(groups.get(from).idGroupe);
        return path == null ? null : groups.get(from).word + " " + path;
    }
}