public static void main(String[] args) {
    int minRequiredMatch = 2;
    List<String> list = Arrays.asList("wel123","123@@!","@@@aaa","!!!BDC","ABC123","rrirrra","1234567","ABCFESS","@@@!!!!");

    list.forEach(x -> {
        System.out.println(x + " - " + (validateTwoCharSets(x, minRequiredMatch)?"Valid":"Invalid"));
    });
}

public static boolean validateTwoCharSets(String str, int minRequiredMatch) {
    List<Pattern> patList = new ArrayList<>();
    patList.add(Pattern.compile("[a-z]"));
    patList.add(Pattern.compile("[A-Z]"));
    patList.add(Pattern.compile("[0-9]"));
    patList.add(Pattern.compile("[!#+,-./:=@]"));

    return validateTwoCharSets(patList, str, minRequiredMatch);
}

public static boolean validateTwoCharSets(List<Pattern> patList, String str, int minRequiredMatch) {
    if (minRequiredMatch <0 || minRequiredMatch > patList.size()) {
        throw new RuntimeException("minRequiredMatch must be a positive number and not more than pattern list size.");
    }
    int matchCount = 0;

    for (Pattern p : patList) {
        Matcher m = p.matcher(str);
        if (m.find()) {
            matchCount++;
        }
        if (matchCount >= minRequiredMatch) {
            return true;
        }
    }

    return false;
}