public static void main(String[] args) {
    Set<Combination> set = new HashSet<>();
    set.add(new Combination("1+2+3"));
    set.add(new Combination("1+2+4"));
    System.out.println(set.contains(new Combination("3+2+1"))); // prints "true"
    System.out.println(set.contains(new Combination("4+2+1"))); // prints "true"
    System.out.println(set.contains(new Combination("4+3+1"))); // prints "false"
}