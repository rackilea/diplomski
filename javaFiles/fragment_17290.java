String rhyme =
                ":Humpty Dumpty sat on a wall\n" +
                "//Humpty Dumpty had a great fall\n" +
                "ssdsds\n";

        Pattern pattern = Pattern.compile("^:(.*?)//(.*[\\s\\S]?)", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(rhyme);
        if (matcher.find()) {
            System.out.println(matcher.group(2));
        } else {
            System.out.println("[Pattern not found]");
        }