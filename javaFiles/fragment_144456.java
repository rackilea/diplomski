int nines = 0;
for(int i = 1; i <= 1000; i++){
    for(char c : String.valueOf(i).toCharArray()){
        if(c == '9') nines++;
    }
}