public class P4Game{
    //INSTANCE VARIABLES
    private int nbLines;
    private int nbColumns;
    private P4Board [][] position;  

    //CONSTRUCTOR  
    public P4Jeu(int nbLines, int nbColumns){
        this.nbColumns = nbColumns;
        this.nbLines = nbLines;
        // You're creating a LOCAL variable called position here if you don't comment what's commented:.
        /*P4Board [][] */position = new P4Board [nbLines][nbColumns]; //Creates the table to receive the instances of the P4Board object.*/
        for (int i=0; i<nbLines; i++){
            for (int j=0; j<nbColumns; j++){
                this.position[i][j] = new P4Board(i,j); //Meant to create each object at (line=i, column=j)
            }
        } 
    }
}