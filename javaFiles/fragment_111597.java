public class SolutionTree{

  TreeNodo root; //it saves the vector [-1,-1] that its initial stage

  //contructor 
  public SolutionTree(byte vectorPosible[], int currentStage){
      this.root=new TreeNodo(vectorPosible, currentStage);
      this.generarTreePSR(root, vectorPosible, vectorPosible.length, currentStage+1); //Generate a Tree of Possible Solutions Recursively
  }

  //Metod to insert Tree Node Recursively

  public static void generarTreePSR(TreeNode father,byte vectorPosible[],int maxStage, int currentStage){  //in this case maxStage is 2

    if(currentStage==maxStage){ //BASE CASE, IF STAGE == 2
      System.out.println("Reached this stage max: "+currentStage);
      System.out.println("I return");
      return;
    }else{ // it isn't in the base case, so tree follow growing

      //NEW TREE NODE1
        TreeNode newNode1=new TreeNode(father.getVectorPos(), currentStage); //<------Solucion
        newNode1.stage=currentStage;

      //NEW TREE NODE2
        TreeNode newNode2= new TreeNode(father.getVectorPos(), currentStage); //<------Solucion
        newNode2.stage=currentStage;


      System.out.print("Look i'm father and i'm before of left, my vector is: ");
      for (int j=0;j<father.vectorPosible.length;j++) { //i show the father vector's
          System.out.print(father.vectorPosible[j]);
          System.out.print(" ");
      }
      System.out.println();


      System.out.println("I'm before if Left, and it is: "+(father.left==null));
      if(father.left==null){
              newNode.vectorPosible[newNode.stage]=0; //insert 0
              father.left=newNode; //asign node

              for (int j=0;j<father.left.vectorPosible.length;j++) { //i show what i insert into this left node
                  System.out.print(father.left.vectorPosible[j]);
                  System.out.print(" ");
              }
              System.out.println();
              System.out.println("Nodo added left with success");
              System.out.println();
              generarTreePSR(father.left, father.left.vectorPosible, maxStage, currentStage+1);
    }

      System.out.print("Look i'm father and i'm before of right, my vector is: ");
      for (int j=0;j<father.vectorPosible.length;j++) { //i show the father vector's
          System.out.print(father.vectorPosible[j]);
          System.out.print(" ");
      }
      System.out.println();

      System.out.println("I'm before if Right, and it is: "+(father.right==null));
      if(father.right==null){
              newNode.vectorPosible[newNode.stage]=1; //insert 1
              father.right=newNode; //asign node

              for (int j=0;j<father.right.vectorPosible.length;j++) {  //i show what i insert into this right node
                  System.out.print(father.right.vectorPosible[j]);
                  System.out.print(" ");
              }
              System.out.println();
              System.out.println("Nodo added right with success");
              System.out.println();
              generarTreePSR(father.right, father.right.vectorPosible, maxStage, currentStage+1);
      }
      return;
  }
 }
}