public int nameScore(String name){
    int score = 0;
    char[] tempName = name.toCharArray();
    for (char i : tempName){
            score += alphValue(i);
        }

    return score;
}