import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Group of code marks
 */
public class CodeMarks {
    /**
     * Keep track of the most recently added suffix (value) by prefix (key)
     */
    HashMap<Integer, Integer> codeMarks = new HashMap<Integer, Integer>();

    /**
     * Add a code mark (i.e. ####-##) to the group.
     * If same prefix already exists overwrite.
     *
     * @param codeMark
     */
    public void add(String codeMark) {
        // add some validation here
        String[] pieces = codeMark.split("\\-");
        Integer prefix = Integer.parseInt(pieces[0]);
        Integer suffix = Integer.parseInt(pieces[1]);
        codeMarks.put(prefix, suffix);
    }

    /**
     * Sort code marks in descending suffix order.
     */
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer prefixA, Integer prefixB) {
            Integer suffixA = codeMarks.get(prefixA);
            Integer suffixB = codeMarks.get(prefixB);
            if (suffixB.equals(suffixA))
                return prefixB.compareTo(prefixA);
            else
                return suffixB.compareTo(suffixA);
        }
    };

    /**
     * Output all code marks in descending suffix order
     */
    public String toString() {
        TreeMap<Integer,Integer> sorted_map  = new TreeMap<Integer,Integer>(comparator);
        sorted_map.putAll(codeMarks);
        StringBuffer output = new StringBuffer();
        for (Integer prefix : sorted_map.keySet()) {
            Integer suffix = sorted_map.get(prefix);
            output.append(prefix + "-" + suffix + "\n");
        }
        return output.toString();
    }

    public static void main(String args[]) {
        CodeMarks cm = new CodeMarks(){{
            add("1001-40");
            add("1002-54");
            add("1003-23");
            add("1001-45");
            add("1004-60");
        }};
        String expected =
                "1004-60\n" +
                "1002-54\n" +
                "1001-45\n" +
                "1003-23\n";
        String actual = cm.toString();
        System.out.println(actual);
        System.out.println("actual.equals(expected): " + actual.equals(expected));
    }
}