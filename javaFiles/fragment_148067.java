Pattern pattern = Pattern.compile("(\\S+) |(\".+\")";
        // one or more non-whitespace characters or quotes around one or more characters
        Matcher matcher = pattern.matcher(message);
        // check all occurance
        while (matcher.find()) {
                String arg = matcher.group();
                // add it to an array 
        }