public class AnnotationIntegerSetFormatter extends Formatters.AnnotationFormatter<IntegerSet,Set> {
    @Override
    public Set<Integer> parse(IntegerSet annotation, String text, Locale locale) {
        Set<Integer> set = new TreeSet<Integer>();
        for (String part : text.split(","))
            set.add(Integer.parseInt(part));

        return set;
    }

    @Override
    public String print(IntegerSet annotation, Set value, Locale locale) {
        List<Integer> sorted = new ArrayList<Integer>();
        sorted.addAll((Set<Integer>) value);
        Collections.sort(sorted);

        return join(",", sorted.toArray());
    }

    private static String join(String separator, Object... values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null)
                continue;

            if (sb.length() > 0)
                sb.append(separator);

            sb.append(values[i].toString());
        }

        return sb.toString();
    }

}