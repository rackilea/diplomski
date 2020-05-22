public String toString() {
    WNode wordTemp = whead;

    String str1 = "";
    while (wordTemp != null) {
        String str = "";
        UNode urlTemp = wordTemp.mid;
        while (urlTemp != null) {
            str += urlTemp.url + " ";
            urlTemp = urlTemp.next;
        }
        str1 += wordTemp.word + ": " + str + "\n";
        wordTemp = wordTemp.next;
        str = ""; //empty the string here
    }
    return str1;
}