public String readNext() {
    if (scan.hasNext()) {
        String word = scan.next();
        if (!word.matches("[A-Za-z]+"))
            word = "";
        storeWord(word);
        return word;
    }
    return null;
}