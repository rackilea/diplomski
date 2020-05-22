public ScoreList(int[] array) {
    // If you have to check array size, do it in here.
    this.scores = new int[array.length];
    for(int i=0;i<array.length;i++) {
        this.scores[i] = array[i];
    } 
}