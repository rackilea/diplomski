String json = str1;  // sample json string
        Pattern codePattern = Pattern.compile("\"code\"\\s*:\\s*\"([^,]*)\",");
        Pattern messagePattern = Pattern.compile("\"message\"\\s*:\\s*\"([^,]*)\",");
        Pattern statusPattern = Pattern.compile("\"status\"\\s*:\\s*\"(FAILURE)\"");

        Matcher code_matcher = codePattern.matcher(json);
        Matcher message_matcher = messagePattern.matcher(json);
        Matcher status_matcher = statusPattern.matcher(json);

        if (code_matcher.find() && message_matcher.find() && status_matcher.find()) {

            System.out.println("\nException found!");

            System.out.println("\n" + code_matcher.group(1));
            System.out.println("\n" + message_matcher.group(1));
            System.out.println("\n" + status_matcher.group(1));
        }