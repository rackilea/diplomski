public static float checkLineForAddress(List<String> testdata) {
        boolean containsZip = false;
        boolean containsState = false;
        boolean containsAddressKeyword = false;
        boolean containsWord = false;
        boolean containsCapitalizedWord = false;
        boolean containsNumber = false;
        boolean containsBuildingNum = false;
        for (String item : testdata) {
            Set<Map.Entry<String, String>> entries = zipRegexps.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                containsZip = containsZip || item.matches(entry.getValue());
                if (containsZip) break;
            }
            containsState = containsState || item.matches("[A-Z]{2}");
            containsBuildingNum = containsBuildingNum || item.contains("/");
            containsWord = containsWord || item.matches("[A-Za-z]+");
            containsCapitalizedWord = containsCapitalizedWord || item.matches("[A-Z]+[a-z]+");
            for (String addressKeyword : addressKeywords) {
                containsAddressKeyword = containsAddressKeyword || item.replace(".", "").equalsIgnoreCase(addressKeyword);
            }
            containsNumber = containsNumber || item.matches("[0-9]+");
        }

        float addressProbability = 0;
        if (containsZip && containsCapitalizedWord && (containsState || containsAddressKeyword)) return 1f;
        if (containsZip && containsWord) addressProbability = 0.5f;
        if (containsCapitalizedWord) addressProbability += 0.1f;
        if (containsAddressKeyword) addressProbability += 0.2f;
        if (containsNumber) addressProbability += 0.05f;
        if (containsBuildingNum) addressProbability += 0.05f;
        if (testdata.size() > 1) addressProbability += 0.05f;
        if (testdata.size() > 2) addressProbability += 0.05f;
        return addressProbability;
    }