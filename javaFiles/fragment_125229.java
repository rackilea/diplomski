for(int i = 0; i<suits.length;i++){
    for(int j = 0; j<faces.length;j++){
        deck[index] = new Card(faces[j],suits[i]);
        index++;
    }
}