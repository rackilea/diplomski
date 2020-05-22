Pattern p = Pattern.compile("(?<=<AccountNumber>)\\d*(?=\\d{4})");
    Matcher m = p.matcher(data);
    StringBuffer maskedResult = new StringBuffer();
    while (m.find()) {
        String thisMask = m.group(0).replaceAll(".", "*");
        m.appendReplacement(maskedResult, thisMask);
    }
    m.appendTail(maskedResult);
    System.out.println(maskedResult.toString());