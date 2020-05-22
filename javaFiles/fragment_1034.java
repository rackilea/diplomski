public String stringfinder(String linktext, String input) {
    String [] inputSplits = input.split("\\s+");
    for (int i = 0; i < inputSplits.length; i += 4) {
        if (inputSplits[i].equals(linktext) {
            return inputSplits[i + 1] + " " + inputSplits[i + 2]
                      + " " + inputSplits[i + 3];
        }
    }
    return "";
}