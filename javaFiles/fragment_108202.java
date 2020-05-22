List<String> allCodes = new ArrayList<String>();

 Matcher m = Pattern.compile("\"status\": (\\d.*)").matcher(YOUR_TEXT);

while (m.find()) {
        allCodes.add(m.group(1));
    }

    System.out.println(allCodes);