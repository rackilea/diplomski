int currentIndex = 0;
for(int i = 0; i < m; i++){
    for(int j = 0; j < n; j++){
        mat[i][j] = array[currentIndex];
        currentIndex = (currentIndex + 1 ) % array.length;
    }
}