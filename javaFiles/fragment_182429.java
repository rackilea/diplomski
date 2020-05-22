final int GRID=10;  
totalp = boundBM.getWidth()/GRID * boundBM.getHeight()/GRID;

//this method now does not need to read boundBM, so it is more opject-oriented
public int countPixels(int x, int y, int h, int w){
    count = 0;
    for (i=x; i<x+w; i++){
        for(k =y; k<y+h; k++){
            if(c != boundBM.getPixel(i, k)) count++;
        }
    }
    //funny thing
    return (count>totalp/3) ? 1 : 0;
}

public void createNeuralInput(){
    int h = boundBM.getHeight()/GRID;
    int w = boundBM.getWidth()/GRID;
    int[][] array= new int[GRID][GRID];
    for(int i = 0; i < GRID; i++) {
        for(int j = 0; j < GRID ; j++) {
            n1.add(countPixels(i*h, j*w, h, w));
            //i would prefer:
            //array[i][j]=countPixels(i*h, j*w);
        }
    }
}