if(Current Weight > Element's Weight)
{
      if(DP[i-1][j-Weight[i]]+Value[i]>DP[i-1][j]){
             DP[i][j]=DP[i-1][j-Weight[i]]+Value[i];
             Weight[i][j]= Weight[i-1][j-Weight[i]]+Value[i]
      }
      else if(DP[i-1][j-Weight[i]]+Value[i] <  DP[i-1][j] ){
             DP[i][j]=DP[i-1][j];
             Weight[i][j]=Weight[i-1][j];
      } 
      else{                   //Note this is the tricky part elsewise the 
                              //Above conditions are simple Knapsack conditions

             DP[i][j]=DP[i-1][j];   //Both of them are equal We will get same Value . Thus we cannot maximise it in any other way!!
             Weight[i][j]=minimum ( Weight[i-1][j] ,Weight[i-1][j-Weight[i]]+A[i]);

      }
}
else
{
             DP[i][j]=DP[i-1][j];
             Weight[i][j]=Weight[i-1][j];
}