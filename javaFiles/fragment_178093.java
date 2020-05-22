public static int Solve(int num){
    int count = 1;
    int end = 0;

    while(end!=1){
        if(evenorodd(num)){
            num = num/2;
            count+=1;
            if(num==1){
                end=1;
                break;
            }
        }
        else 
         {
            num = 3*num +1;
            count+=1;
            if(num==1){
                end=1;
                break;
            }
        }   
    }
    return count;
}