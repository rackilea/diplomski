public static void main(String[] args) {    
        String str = "According to some, dreams express \"profound aspects of personality\" (Foulkes 184), though \"others disagree\" but truth is.";
        Pattern pattern = Pattern.compile("\".*?\"");
        Matcher matcher = pattern.matcher(str);

        List<String> quotes = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();

        while (matcher.find()) {
            String quote = matcher.group();
            int length = quote.length();
            quotes.add(quote.substring(1, length - 1));
            matcher.appendReplacement(buffer, " ");
        }
        matcher.appendTail(buffer);

        System.out.println(buffer.toString());
        System.out.println(quotes);
    }