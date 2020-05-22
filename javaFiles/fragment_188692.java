do{
    full=""
    for (int i = 0; i < totalLine; i++) {
        temp = enterLine(mTextView, textToBeShown, i);
        if(temp.trim().length() == 0){
            break;
        }else{
            full = full + temp;
        }
    }
    Pages.add(full);
}while(...)