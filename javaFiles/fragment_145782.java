public static void main(String[] args)
{
    // the sample input
    String x = "32 X 28 Y 32 X 40 Y 36 X 32 Y 32 X 24 X 32 X";

    // match based upon "32". This specific match can be made into
    // a String concat so the specific number may be specified
    Pattern pat = Pattern.compile("[\\s]*(32\\s[^\\d])");

    // get the matcher
    Matcher m = pat.matcher(x);

    // our collector
    List<String> res = new ArrayList<>();

    // while there are matches to be found
    while (m.find()) {
        // get the match
        String val = m.group().trim();
        System.out.println(val);

        // add to the collector
        res.add(val);
    }

    // sample conversion
    String[] asArray = res.toArray(new String[0]);
    System.out.println(Arrays.toString(asArray));
}