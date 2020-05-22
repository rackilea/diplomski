public static void main(String[] args) {
    Set<String> ss = new HashSet<String> ();
    ss.add("Hello");
    Set<Integer> is = unsecureCast(ss);
}

static Set<Integer> unsecureCast(Set s) {
    return (Set<Integer>) s;
}