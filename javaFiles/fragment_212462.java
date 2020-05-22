public static String getDefinition(String acronym, String sentence) {
    if (!sentence.toLowerCase().contains(acronym.toLowerCase())) {
        return null;
    }

    StringBuilder patternBuilder = new StringBuilder();
    for (char letter : acronym.toCharArray()) {
        patternBuilder.append("[");
        patternBuilder.append(Character.toLowerCase(letter));
        patternBuilder.append(Character.toUpperCase(letter));
        patternBuilder.append("]");
        patternBuilder.append("\\w*\\s+");
    }
    patternBuilder.delete(patternBuilder.length() - 3, patternBuilder.length());

    Pattern pattern = Pattern.compile(patternBuilder.toString());
    Matcher matcher = pattern.matcher(sentence);
    if (!matcher.find()) {
        return null;
    }

    return matcher.group();
}

public static void main(String[] args) {
    String acronym = "AED";
    String sentence = "This will be much like the \"Kindle\" or Automated External Defibrillator (AED)";
    String definition = getDefinition(acronym, sentence);
    if (definition != null) {
        System.out.println(acronym + " = " + definition);
    } else {
        System.out.println("There is no definition for " + acronym);
    }
}