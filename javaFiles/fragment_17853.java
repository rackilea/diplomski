public void printAll(String dna) {
    int start = 0;
    while (true) {
        int atg = dna.indexOf("atg", start);
        if (atg == -1) {
           break; 
        }
        int end = findStopIndex(dna, atg+3);
        if (end != dna.length()) {
            System.out.println(dna.substring(atg, end+3));
            start = end + 3;
        }
        else {
            start = start+3;
        }
    }
}