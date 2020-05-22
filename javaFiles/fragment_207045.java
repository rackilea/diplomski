public int[] load() throws IOException {
    File fp = new File("realtext.txt");
    BufferedReader in = new BufferedReader(new FileReader(fp));
    int[] count = new int[26];
    int nextChar;
    while ((nextChar = in.read()) != -1) {
        int ch = ((char) nextChar);
        if (ch >= 'a' && ch <= 'z') {
            count[ch - 'a']++;
        }
    }

    int[] position = new int[count.length];
    for (int k = 0; k < 26; k++) {
        position[k] = k;
    }
    for (int k = 0; k < 26; k++) {
        int max = count[k];
        int maxpos = k;
        for (int l = k + 1; l < 26; l++) {
            if( count[l] > max ){
                max = count[l];
                maxpos = l;
            }
        }
        int h = count[k];
        count[k] = count[maxpos];
        count[maxpos] = h;
        h = position[k];
        position[k] = position[maxpos];
        position[maxpos] = h;
    }

    int trans[] = new int[position.length];
    System.out.println("Descending order");
    for (int k = 0; k < 26; k++) {
        trans[position[k]] = k;
        System.out.printf("%c = %d -> %d-th\n",
                          position[k] + 'A', count[k], k);
    }
    return trans;
}