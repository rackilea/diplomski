public String fixNoun(String noun) {
    if(noun.endsWith("a")) {
        return("la " + noun);
    else if(noun.endsWith("o")) {
        return("el " + noun);
    else {
        return("? " + noun);
    }
}