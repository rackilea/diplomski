// the words you want to remove from the file:
    //
    Set<String> wordsToRemove = ImmutableSet.of("a", "for");

    // this code will run in a loop reading one line after another from the file
    //
    String line = "Some words read from a file for example";
    StringBuffer outputLine = new StringBuffer();
    for (String word : Splitter.on(Pattern.compile("\\s+")).trimResults().omitEmptyStrings().split(line)) {
        if (!wordsToRemove.contains(word)) {
            if (outputLine.length() > 0) {
                outputLine.append(' ');
            }
            outputLine.append(word);
        }
    }

    // here I'm just printing, but this line could now be written to the output file.
    //
    System.out.println(outputLine.toString());