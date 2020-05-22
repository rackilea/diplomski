for(int b = divider-1; b > 0; b--){
    if(x[divider] < x[b]){
        int temp = x[divider];
        x[divider] = x[b];
        x[b] = temp;
    }
}