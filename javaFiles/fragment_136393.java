public void determineRuleActionRegion(String str) {
    //remove repetitive spaces and concat $ for new line indicator
    str = str.trim().replaceAll(" +", " ") + "$";
    String[] lines = str.split("\r?\n|\r");
    String lastLine = lines[lines.length - 1];
    String[] tokens = lastLine.split("\\s+", -1);
    int pos = (tokens.length <= 7) ? tokens.length : -1;
    triggerSuggestionList(pos);
    System.out.println("Current pos: " + pos);
    return;
} //end of determineactionRegion()