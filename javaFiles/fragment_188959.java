int x = input.nextInt();
while(x!=0){
    sum+=x;
    if(x<0){
        negatives++;
    }else if(x>0){
        positives++;
    }
    count++;
    x = input.nextInt();
}