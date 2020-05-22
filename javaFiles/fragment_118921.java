Pattern pattern = Pattern.compile("\\{(.*?)\\}");
        Matcher matcher = pattern.matcher(str);

        while (matcher.find()) {
            System.out.println("->" + matcher.group().replaceAll("[{}]",""));
        }