int x, y;//Grid
int xx, yy;//Screen
int GridSize = 3;

public void tick(){
    if(x * GridSize > xx){
        xx ++;
    }        
    if(x * GridSize < xx){
        xx --;
    }
    if(y * GridSize > yy){
        yy ++;
    }
    if(y * GridSize < yy){
        yy --;
    }
}