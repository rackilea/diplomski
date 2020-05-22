long bigMul = 0;
List<Integer> list = new ArrayList<>(); // <-- not a global or raw-type
String nodes = reader.next();
for (int i = 0; i < nodes.length(); i++) {
    list.add(Character.digit(nodes.charAt(i), 10)); // <-- char to int
    if (list.size() == 13) {
        bigMul = Math.max(bigMul, multiply(list));
        list.remove(0);
    }
}