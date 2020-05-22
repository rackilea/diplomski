public class TreeNodo{
    public byte vectorPosible[]; 
    public int stage; //my stages and index posision of array

    public TreeNodo right; // if goes to right mean 1, in index posision of array
    public TreeNodo left; // if goes to right mean 0, in the index posision of array

    //contructor
    public TreeNodo(byte vectorPosible[], int currentStage){
      this.vectorPosible=vectorPosible;
      this.stage=currentStage; 
      this.right=null;
      this.left=null;
  }
}