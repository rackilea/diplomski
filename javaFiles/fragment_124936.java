private boolean isOk(int j){
    for(int i = 0; i < 20; i++){
        if (locations[i][2] == j) return false;
    }
    return true;
}