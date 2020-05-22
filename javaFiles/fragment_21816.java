for (int i = 0; i < locationCells.length; ++i) {
    int cell = locationCells[i];
    if (guess==cell){
        result ="hit";
        numOfHits++;
        break;
    }
}