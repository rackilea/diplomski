public int numberOfChildren(){
    int count=0;
    for(int i=0;i<passengers.length;i++){
        if(passengers[i].age < 16){
            count++;
        }
    }
    return count;
}
public int totalWeight(){
    int sum=0;
    for(int i=0;i<passengers.length;i++){
        sum+=passengers[i].weight;
    }
    return sum;
}