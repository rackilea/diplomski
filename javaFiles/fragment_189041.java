boolean foundMatch = false;
    try {
        foundMatch = subjectString.matches("(?:(?:ab(?:cd|efgjkln))|(?:(?:ef?jkln))){15,}");
    } catch (PatternSyntaxException ex) {
        // Syntax error in the regular expression
    }