public void lowerVolume(){
    volume--; // <-- does - 1
    if (volume < 0){ // <-- less than
        volume = 0;
    }
}