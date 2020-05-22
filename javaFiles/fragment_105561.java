public class clearBlankGrid {

   private Monster myMonster;
   private MonsterGUI myGUI;

   public void run() {
       myMonster = new Monster(10,10,5,5,1);
       myGUI = new MonsterGUI(myMonster);

       if (myMonster.getRows() > 0) {   
            // 0 = North, 1 = East, 2 = South, 3 = West
            myMonster.setFacing(3);
            myMonster.setIcon();
        }
   }

    public void keepClearing() {
        myMonster.isGridCleared();
    }

    public static void main(String args[]) {
        clearBlankGrid blankGrid = new clearBlankGrid();
        blankGrid.run();
    }
}