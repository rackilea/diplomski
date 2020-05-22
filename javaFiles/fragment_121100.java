if(this.word.contains(this.letterGuessed)) {

    // look for an occurrence, 
    // if you have one, keep looking for others until you have them all (ie: index = -1)
    List<Integer> indexes = new ArrayList<>();
    int index = this.word.indexOf(this.letterGuessed);
    while (index >= 0) { // <- that will loop until the indexOf returns a -1
        indexes.add(index);
        index = this.word.indexOf(this.letterGuessed, index+1);
    }

    // replace at all the found indexes
    StringBuilder newString = new StringBuilder(this.clone);
    for(int letterIndex : indexes) {
        char c = this.word.charAt(letterIndex);
        newString.setCharAt(letterIndex, c);
    }

    this.clone = newString.toString();

} else {
    this.guessesLeft--;
}