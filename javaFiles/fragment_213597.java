max = score[0];
int x = 0;
Student temp = null;
for (int i=0; i < score.length; i++) {
    x = score[i].avgScore;
    temp = score[i];
    if (x < score[i+1].avgScore ) {
        score[i] = score[i+1];
        score[i+1] = temp;
    }
}