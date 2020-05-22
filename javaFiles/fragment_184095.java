boolean finishedFlag = true;
for(int x = 1; x < 4; x++){
    if (board[x] != ch){
        finishedFlag = false;
        break;
    }   
}
if(finishedFlag) return finishedFlag;

/*

...
Check similarly for all horizontal,vertical and diagonal
...

*/

return finishedFlag;