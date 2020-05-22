boolean found = false;
int size = numberOfElements;
for(int i=0; i<size;i++) {
    if(gc.choosePiece(position, gameBoardModel,(ImageView) v)==true) {
        found = true;
        break;
    }
}
if(found) {
// do what u expect
}