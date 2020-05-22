for (int n = 0; n < input.size(); n++) { //outside FOR (INPUT)
    String checker = input.get(n).trim();
    boolean match = false;
    for (int i = 0; i < myDict.size(); i++) { //inside FOR (dictionary)
        String currentWord = myDict.get(i).trim();
        System.out.print(checker + " " + currentWord + "\n");
        if (checker.equals(currentWord)) {
            match = true;
            results.add(currentWord);
            break;
        } //end if
    } //end inside FOR (dictionary)
    if (!match) {
        results.add("No match for " + checker);
    }
} //END OUTSIDE FOR (input)