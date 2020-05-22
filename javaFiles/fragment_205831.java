public void trigram() throws FileNotFoundException{
PrintWriter tg = new PrintWriter(new File(trigramFile));
// CREATES THE TRIGRAM
for (int i = 0; i < bagOfWords.size() - 2; i++) {
    for (int j = i + 1; j < bagOfWords.size() - 1; j++) {
        for(int k = j + 1; k < bagOfWords.size(); k++){
            int distance = (k - i);
            trigramList.add(bagOfWords.get(i) + " " + bagOfWords.get(j) + " " + bagOfWords.get(k) + ", " + distance);
        }
    }
}