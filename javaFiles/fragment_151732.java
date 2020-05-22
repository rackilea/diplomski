try (Scanner in = new Scanner(new File(fileName))) {

    while (in.hasNextLine()) {
        String dictionaryword = in.nextLine();
        dictionary.add(dictionaryword);        
    }

}