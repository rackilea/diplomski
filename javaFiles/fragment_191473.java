int answers[][] = new int[20][5];

for( int i = 0; i < 20; i++) {
    for( int j = 0; j < 5; j++){
         answers[i][j] = this.getResources().getIdentifier("a"+(j+1)+"_"+(i+1)_" + number, "string", this.getPackageName());
    }
}