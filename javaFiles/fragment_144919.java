import java.util.*;

public class RegexUtils {

    private static String encode(char c) {
        switch (c) {
            case '[':
            case ']':
            case '\\':
            case '-':
            case '^':
                return "\\" + c;
            default:
                return String.valueOf(c);
        }
    }

    public static String createCharClass(char[] chars) {

        if (chars.length == 0) {
            return "[^\\u0000-\\uFFFF]";
        }

        StringBuilder builder = new StringBuilder();

        boolean includeCaret = false;
        boolean includeMinus = false;

        List<Character> set = new ArrayList<Character>(new TreeSet<Character>(toCharList(chars)));

        if (set.size() == 1<<16) {
            return "[\\w\\W]";
        }

        for (int i = 0; i < set.size(); i++) {

            int rangeLength = discoverRange(i, set);

            if (rangeLength > 2) {
                builder.append(encode(set.get(i))).append('-').append(encode(set.get(i + rangeLength)));
                i += rangeLength;
            } else {
                switch (set.get(i)) {
                    case '[':
                    case ']':
                    case '\\':
                        builder.append('\\').append(set.get(i));
                            break;
                    case '-':
                        includeMinus = true;
                        break;
                    case '^':
                        includeCaret = true;
                        break;
                    default:
                        builder.append(set.get(i));
                        break;
                }
            }
        }

        builder.append(includeCaret ? "^" : "");
        builder.insert(0, includeMinus ? "-" : "");

        return "[" + builder + "]";
    }

    private static List<Character> toCharList(char[] chars) {
        List<Character> list = new ArrayList<Character>();
        for (char c : chars) {
            list.add(c);
        }
        return list;
    }

    private static int discoverRange(int index, List<Character> chars) {
        int range = 0;
        for (int i = index + 1; i < chars.size(); i++) {
            if (chars.get(i) - chars.get(i - 1) != 1) break;
            range++;
        }
        return range;
    }

    public static void main(String[] args) {
        System.out.println(createCharClass("daecb".toCharArray()));
        System.out.println(createCharClass("[]^-".toCharArray()));
        System.out.println(createCharClass("".toCharArray()));
        System.out.println(createCharClass("d1a3e5c55543b2000".toCharArray()));
        System.out.println(createCharClass("!-./0".toCharArray()));
    }
}