for (int i=0; i<24; i++) {
    int x = (i%6)*100;
    int y = (i/6)*50;
    //Array indexes start from 1, whereas this  
    //loop starts from 0, hence adjusting below
    rects[i+1].setLocation(x, y);
}