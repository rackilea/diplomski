@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(" "); // remove this if you do not want two spaces at the front of the returned string
    for (int i = 0; i < this.wordList.size(); i++) {
        sb.append(" " + this.wordList.get(i).toString());
    }
    return sb.toString();
}