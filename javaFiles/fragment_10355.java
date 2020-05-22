private void handleKeyPress(int keyCode) {
    int emptyIndex = findEmptyIndex();
    int x = emptyIndex/SIZE;
    int y = emptyIndex%SIZE;

    switch (keyCode) {
    case 37://LEFT KEY
        if(y==SIZE-1) return;
        doSwap(x,y,x,y+1);
        break;
    case 38://UP KEY
        if(x==SIZE-1) return;
        doSwap(x,y,x+1,y);
        break;
    case 39://RIGHT KEY
        if(y==0) return;
        doSwap(x,y,x,y-1);
        break;
    case 40://DOWN KEY
        if(x==0) return;
        doSwap(x,y,x-1,y);
        break;
    }
}