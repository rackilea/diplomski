for(int i = 0; i < 4; i++) {
 for (int j = 0; j < 6; j++) {
    int g = pieces.remove(pieces.size()-1);
    kaart[i][j] = loadImage( g + ".jpg" );
    kaart[i][j].resize(vlakGrootte - 1, vlakGrootte - 1);
 }
}