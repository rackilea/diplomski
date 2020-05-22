for(n) {
  for(m) {
       int p=0;
        for(;p<rows.length;p++){
            int q=0;
            for(;q < rows[0].length;q++){
                if((rows[p][q]==1)&&(num[p][q]==1)){
                    score+=1;
                }
                else if((num[p][q]==1)&&(rows[p][q]==0)){
                    score-=.25;
                }
                else if((num[p][q]==0)&&(rows[p][q]==0)){
                    score+=.25;
                }
            }
        }
        if(score>highest){
          highest=score;
          score=0;
        }
        else{
          score=0;
        }
    } // end m
} // end n