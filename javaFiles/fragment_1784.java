public int getFinalScore(List<Score> scores) {
    int final_score = 0;

    for(int s: scores){
        final_score += s;
    }

    return final_score;
}