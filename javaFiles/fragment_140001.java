public static void main(String[] args) {

    String s = "de70d4de8c47385536c8e08348032c3b";

    Matcher m = Pattern.compile("..").matcher(s);

    List<Byte> bytes = new ArrayList<Byte>();
    while (m.find())
        bytes.add((byte) Integer.parseInt(m.group(), 16));

    System.out.println(bytes);
}