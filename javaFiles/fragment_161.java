String[] words = {"bob","alice","keith","zoe","sarah","gary"};

boolean isSwapped = false;
do {
    isSwapped = false;
    for(int i=0;i<words.length-1;i++){
        if(words[i].compareTo(words[i+1])>0){
            String temp = words[i+1];
            words[i+1] = words[i];
            words[i] = temp;
            isSwapped = true;
        }
    }
}while((isSwapped));