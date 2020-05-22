else
    if(j - 1 >= 0 && goals[i][j-1].isHit())
    {
        Goal temp=goals[i][j-1];
        goals[i][j-1]=goals[i][j];
        goals[i][j]=temp;
    }