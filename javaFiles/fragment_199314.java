private static final String MATRICULE_REGEX = "1\\d{6}(\\n1\\d{6})*";

    Pattern matriculePattern = Pattern.compile(MATRICULE_REGEX);
    Matcher matriculeMatcher = null;
    matriculeMatcher = matriculePattern.matcher(text);
    isValidMatricule = matriculeMatcher.matches();