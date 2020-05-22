Pattern p = Pattern.compile("(?<=<AccountNumber>)([-\\s\\w]*)((?:[a-zA-Z0-9][-_\\s]*){4})");
    Matcher m = p.matcher(data);
    StringBuffer maskedResult = new StringBuffer();
    while (m.find()) {
        String thisMask = m.group(1).replaceAll("[^-_\\s]", "*");
        m.appendReplacement(maskedResult, thisMask + "$2");
    }
    m.appendTail(maskedResult);
    System.out.println(maskedResult.toString());