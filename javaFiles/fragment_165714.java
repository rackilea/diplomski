char[] Select = {'A','B','C','D','E','F','G','H','I','J'};
int[] Weight = {10,30,25,60,20,70,10,80,20,30};
int sum = 355;
for(int a=0;i<5;i++){
    int rand = (int)(Math.random()*sum);
    int s=0;//temp cumulative sum
    int i=0;
    while( (s+=Weight[i])<rand)i++;
    result.add(Select[i]);

    sum-=Weight[i];//total weight is lower now
    Weight[i]=0;//if weight is 0 it will never be selected

}