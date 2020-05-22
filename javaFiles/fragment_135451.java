public static void main(String[] args) {
        try {
            String tag = "%variable1%%variable2%";
            Pattern regex = Pattern.compile("\\%.*?\\%");

            Matcher regexMatcher = regex.matcher(tag);
            while (regexMatcher.find()) {
                System.out.println(regexMatcher.group());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }