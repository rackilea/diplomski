do{
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < totalLine; i++) {
        temp = enterLine(mTextView, textToBeShown, i));
        if(temp.trim().length() == 0){
            break;
        }else{
            builder.append(temp);
        }
    }
    Pages.add(builder.toString());
}while(...)