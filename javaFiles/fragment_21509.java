for(int i=1;i<length;i++){
    if(data[i-1] > data[i]){
        temp = data[i];
        data[i] = data[i-1];
        data[i-1] = temp;
    }