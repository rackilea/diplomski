List<String> strings = Arrays.asList("ohai", "wat", "fuuuu", "kthxbai");
boolean well = Iterables.any(strings, new Predicate<String>() {
    @Override public boolean apply(@Nullable String s) {
        return s.equalsIgnoreCase("fuuuu");
    }
});
System.out.printf("Do any match? %s%n", well ? "Yep" : "Nope");