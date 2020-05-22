for (int i=0;i<Keywords.length-1;i++){
    for(int j = i+1; j < Keywords.length; j++){
        int count = 0;
        for (int q=0;q<Sentence.length;q++){
            if(Sentence[q].contains(Keywords[i]) && Sentence[q].contains(Keywords[j])){
                count++;
            }
        }
        matrix[i][j] = count;
        matrix[j][i] = count;        
    }
}