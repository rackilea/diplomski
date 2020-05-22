public static List<String> multiEntry(final String myString)
{
    String[] parts = myString.split("<as:");

    List<String> col = new ArrayList<>();
    if (! parts[0].trim().isEmpty()) {
        col.add(parts[0]);
    }

    Pattern pat = Pattern.compile("^(.*?)s>(.*)?");        
    for (int i = 1; i < parts.length; ++i) {
        Matcher m = pat.matcher(parts[i]);
        if (m.matches()) {
            for (int j = 1; j <= m.groupCount(); ++j) {
                String s = m.group(j).trim();
                if (! s.isEmpty()) {
                    col.add(s);
                }
            }
        }
    }

    return col;
}