int flag;
int lastBallAdded = 0;
int k = numOfBalls/numOfBoxes;
int m = numOfBalls%numOfBoxes;

for(int i = 0; i < numOfBoxes; i++, lastBallAdded+=k+flag) {
    flag = i<m;

    for(int j=lastBallAdded;j<lastBallAdded + k + flag;j++) 
        boxes.get(i).add(balls.get(j));
}