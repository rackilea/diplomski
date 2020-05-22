class Tokenizer {
    //for Java older than 8
    public static String joinString(Iterable<String> strings, String separator) {
        StringBuilder sb = new StringBuilder();
        String sep = "";
        for(String s: strings) {
            sb.append(sep).append(s);
            sep = separator;
        }
        return sb.toString();                           
    }

    public static void main(String args[]) {
        ArrayList<String> strings = new ArrayList<String>() {{
            add("Welcome|");
            add("To|");
            add("Stackoverflow|");
            add(";");
            add("Welcome|");
            add("To|");
            add("Zootopia|");
            add(";");
            add("This|");
            add("is|");
            add("last - String|");
            add(";");
        }};

        //String in = String.join("", strings);
        String in = joinString(strings, "");

        for(String outerToken : in.split(";")) {
            System.out.println(outerToken);
            for(String innerToken : outerToken.split("\\|")) {
                System.out.println("\t" + innerToken);
            }
        }
    }
}