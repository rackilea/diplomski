abstract class Ball{
    private int size;
    protected Ball(int size){
        this.size = size;
    }    
    protected void setSize(int size){
        this.size = size;
    }
    protected int getSize(){
        return size;
    }          
}