public String FindBestMatch() {
    String[] m = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    double max = compareMatrices(numFiles.getMatrix(m[0]), imgMatrix);
    double score = 0;
    int maxIndex = 0;

    for(int i = 1 ; i < m.length ; i++) {
        score = compareMatrices(numFiles.getMatrix(m[i]), imgMatrix);

        if(score > max) {
            max = score;
            maxIndex = i;
        }
    }

    return m[i];
}