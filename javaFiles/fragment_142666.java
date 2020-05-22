class Pair<T,U> {
    T _1;
    U _2;
    public Pair(T t, U u) { _1 = t; _2 = u; }
}

List<Pair<String,String>> pairs = new ArrayList<>();
pairs.add(new Pair<>("Hello", "World"));
pairs.add(new Pair<>("Pair", "Words"));
pairs.add(new Pair<>("Another", "Pair"));

for (Pair<String,String> pair : pairs) {
    System.out.println("First: " + pair._1 +
                       ", Second: " + pair._2);
}