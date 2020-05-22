public static ArrayList<String> PB2Scan(String filePath, ArrayList<String> Pal, int resultType) 
                                throws FileNotFoundException, IOException {
    // Make sure the supplied result type is either 
    // 0, 1, or 2. If not then default to 0.
    if (resultType < 0 || resultType > 2) {
        resultType = 0;
    }
    ArrayList<String> PalindromesSpotted = new ArrayList<>();

    File file = new File(filePath);
    Scanner sc = new Scanner(file);
    sc.useDelimiter(">");
    //initializes the ArrayList
    ArrayList<String> Gene1 = new ArrayList<>();
    //Loads the Array List
    while (sc.hasNext()) {
        Gene1.add(sc.next());
    }
    sc.close(); // Close the read in text file.

    for (int i = 0; i < Gene1.size(); i++) {
        //Acc breaks down the title so the element:
        //>AX225014 Equine influenza virus H3N8 // 1 (PB2)
        //ATGAAGACAACCATTATTTTGATACTACTGACCCATTGGGTCTACAGTCAAAACCCAACCAGTGGCAACA
        //GGCATGTCCGCAAACGATTTGCAGACCAAGAACTGGGTGATGCCCCATTCCTTGACCGGCTTCGCCGAGA
        //comes out as AX225014
        String Acc = Accession(Gene1.get(i));

        //seq takes the same element as above and returns only
        //ATGAAGACAACCATTATTTTGATACTACTGACCCATTGGGTCTACAGTCAAAACCCAACCAGTGGCAACA
        //GGCATGTCCGCAAACGATTTGCAGACCAAGAACTGGGTGATGCCCCATTCCTTGACCGGCTTCGCCGAGA
        String seq = trimHeader(Gene1.get(i));
        for (int x = 0; x < Pal.size(); x++) {
            if (seq.contains(Pal.get(x))) {
                String match = Pal.get(x) + " in organism: " + Acc + 
                                " Was found in position(s): " + 
                                findSubstringIndexes(seq, Pal.get(x));
                PalindromesSpotted.add(match);
            }
        }
    }

    // If there is nothing to work with get outta here.
    if (PalindromesSpotted.isEmpty()) {
        return PalindromesSpotted;
    }

    // Sort the ArrayList
    Collections.sort(PalindromesSpotted);
    // Another ArrayList for matching Pal's to Acc's
    ArrayList<String> accMatchingPal = new ArrayList<>();
    switch (resultType) {
        case 0: // if resultType is 0 is supplied
            writeListToFile("PB2Out.txt", PalindromesSpotted);
            return PalindromesSpotted;

        case 1: // if resultType is 1 is supplied
            accMatchingPal = getPalMatches(PalindromesSpotted);
            writeListToFile("PB2Out.txt", accMatchingPal);
            return accMatchingPal;

        default: // if resultType is 2 is supplied
            accMatchingPal = getPalMatches(PalindromesSpotted);
            ArrayList<String> fullList = new ArrayList<>();
            fullList.addAll(PalindromesSpotted);
            // Create a Underline made of = signs in the list.
            fullList.add(String.join("", Collections.nCopies(70, "=")));
            fullList.addAll(accMatchingPal);
            writeListToFile("PB2Out.txt", fullList);
            return fullList;
    }
}