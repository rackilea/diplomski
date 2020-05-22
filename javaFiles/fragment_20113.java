public static void main(String[] args) {
    DefaultDict<Integer, List<Integer>> dict =
        new DefaultDict<Integer, List<Integer>>(ArrayList.class);
    dict.get(1).add(2);
    dict.get(1).add(3);
    System.out.println(dict);
}