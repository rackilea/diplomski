max1 = maximum(player1);
max2 = maximum(player2);

int maximum(ArrayList A)
{
int max = 0;
    for(int s=0; s<A.size(); s++){
        if(A.get(s)>max){
            max=A.get(s);
        }
   } 
return max;
 }