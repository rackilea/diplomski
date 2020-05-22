Pattern p = Pattern.compile("Java");//any regex
        List<String> inputStrings = new ArrayList<String>();
        List<String> matched = new ArrayList<String>();
        //test strings
        inputStrings.add("Java hello");
        inputStrings.add("Javaaa");
        inputStrings.add("aaaJavaaa");
        inputStrings.add("Jvaaa");
        //do
        for (String curStr : inputStrings) {
            Matcher matcher = p.matcher(curStr);
            while (matcher.find()) {
                matched.add(curStr);
            }
        }