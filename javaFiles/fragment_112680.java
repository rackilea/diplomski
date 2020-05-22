enum Terrain {    
    Forest(12), Mountain(9);         // And other Terrain types...
    private int move;    
    private Terrain(int mo) {
        move=mo;
    }
    public int getMove(){
        return move;
    }
}