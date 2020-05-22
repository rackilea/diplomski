public class TranslateChar {

    /** @param args */
    public static void main(final String[] args) {
        final Map<Character, Character> mapCharCod = new HashMap<>(36);
        final Map<Character, Character> mapCharDecod = new HashMap<>(36);
        mapCharCod.put('A', 'Z');
        mapCharCod.put('B', 'X');
        mapCharCod.put('C', 'Y');
        mapCharDecod.put('Z', 'A');
        mapCharDecod.put('X', 'B');
        mapCharDecod.put('Y', 'C');

        final String toCod = "CAB";
        StringBuilder sb = new StringBuilder("{");
        for (final char c : toCod.toCharArray()) {
            sb.append(mapCharCod.get(c));
            sb.append(',');
        }
        sb.setCharAt(sb.length() - 1, '}');
        System.out.println(sb.toString());

        final String deCod = "{Y,Z,X}";
        sb = new StringBuilder();
        for (final char c : deCod.toCharArray()) {
            if (c == '{' || c == ',' || c == '}') {
                continue;
            }
            sb.append(mapCharDecod.get(c));
        }
        System.out.println(sb.toString());
    }
}