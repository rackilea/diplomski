public static void main (String[] args) throws java.lang.Exception
{
    String input = "ab";
    HashMap<Character, String> replacements = new HashMap<Character, String>() {{
        put('a', "bhduh");
        put('b', "eiaja");
    }};

    StringBuilder sb = new StringBuilder();
    for (char c : input.toCharArray()) {
        String rep = replacements.get(c);
        if (rep != null) {
            sb.append(rep);
        }
    }
    System.out.println(sb.toString());
}