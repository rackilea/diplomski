String line = "What is (Rakesh)'s gift (limit)? <=> Personname <=> Amount::Spent";
    if (line.contains("<=>")) {
        String[] example_split = line.split("<=>", 2);
        System.out.println("String is " + example_split[1]);
        if (example_split[0].length() > 1) {
            String[] example_entity = example_split[1].split("<=>");

            int openParamCount = line.length() - line.replace("(", "").length();
            int closeParamCount = line.length() - line.replace("(", "").length();
            System.out.println(openParamCount + "\t" + closeParamCount);
            if (!(openParamCount == closeParamCount))
                System.out.println("Paranthesis don't match for " + line);
            if (!(openParamCount == example_entity.length))
                System.out.println(
                        "The entities provided and the words marked in paranthesis don't match for " + line);

            int entities_count = 0;
            int startPosition;
            int endPosition = 0;
            List<String> matchList = new ArrayList<>();
            Pattern regex = Pattern.compile("\\((.*?)\\)");
            Matcher regexMatcher = regex.matcher(line);
            while (regexMatcher.find()) {
                startPosition = regexMatcher.start() + 1;
                endPosition = regexMatcher.start() - 1;

                matchList.add(regexMatcher.group(1));
                System.out.println("start position is " + startPosition + " end position is " + endPosition
                        + " Entity Type" + example_entity[entities_count]);
            }
            entities_count++;
        }
    }