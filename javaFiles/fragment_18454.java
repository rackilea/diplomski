int sentenceCount=0;
int lastIndex=0; 
for(int i=0;i<myFile.length();i++){  
    for(int j=0;j<SENTENCE_DELIMETERS.length();j++){  
        if(myFile.charAt(i)==SENTENCE_DELIMETERS.charAt(j)){
            if(lastIndex!=i-1){
                sentenceCount++;
            }
            lastIndex=i;
        }
    }
}