Set<String> setFromCollection1 = new HashSet<>(collection1);
for (String s : collection2) {
    if (setFromCollection1.contains(s)) {
        System.out.println("matched");
    }
}