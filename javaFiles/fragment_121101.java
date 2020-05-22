if(this.word.contains(this.letterGuessed)) {
    StringBuilder newString = new StringBuilder(this.clone);

    int index = this.word.indexOf(this.letterGuessed);
    while (index >= 0) {
        char c = this.word.charAt(index);
        newString.setCharAt(index, c);
        index = this.word.indexOf(this.letterGuessed, index+1);
    }

    this.clone = newString.toString();
    System.out.println("clone = " + clone);
} else {
    this.guessesLeft--;
}