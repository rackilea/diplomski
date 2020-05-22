public void addWord( String word, int num ) {
    String upperCaseWord = word.toUpperCase();

    for ( IndexEntry x : this ) {
        String i = x.getWord();
        if (i.equals(upperCaseWord)){
            x.add(num);
            return;
        }
    }

    IndexEntry entry = new IndexEntry(word);
    entry.add(num);

    int currSize = this.size();     
    if (currSize == 0) {
        this.add(entry);
        return;
    }   

    int count = 0;
    while (count < currSize) {
        String str = this.get(count).getWord();
        if (str.compareTo(upperCaseWord) > 0){
            break;
        }   

        count++;
    }   

    this.add(count, entry);
}