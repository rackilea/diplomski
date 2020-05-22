public static void main(String[] args) {
  SwingUtilities.invokeLater(new Runnable() {
     public void run() {
        doOnEventThread();
     }
  });
}

public static void doOnEventThread() {
    try{
        /*creates the matrix of the different types 
         *and their effectiveness to each other. 0
         *represents "Not very effective", 1 is "Neutral"
         *2 is "Super effective", 3 is "No Damage"
        */

        int[][] myTypeArray = 
            {{1, 1, 1, 1, 1, 0, 1, 3, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 1, 0, 0, 1, 2, 0, 3, 2, 1, 1, 1, 1, 0, 2, 1, 2, 0},
                {1, 2, 1, 1, 1, 0, 2, 1, 0, 1, 1, 2, 0, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1, 0, 3, 1, 1, 2, 1, 1, 1, 1, 1, 2},
                {1, 1, 3, 2, 1, 2, 0, 1, 2, 2, 1, 0, 2, 1, 1, 1, 1, 1},
                {1, 0, 2, 1, 0, 1, 2, 1, 0, 2, 1, 1, 1, 1, 2, 1, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 2, 1, 2, 1, 1, 2, 0},
                {3, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 2, 1, 1, 0, 0, 0, 1, 0, 1, 2, 1, 1, 2},
                {1, 1, 1, 1, 1, 0, 2, 1, 2, 0, 0, 2, 1, 1, 2, 0, 1, 1},
                {1, 1, 1, 1, 2, 2, 1, 1, 1, 2, 0, 0, 1, 1 ,1, 0, 1, 1},
                {1, 1, 0, 0, 2, 2, 0, 1, 0, 0, 2, 0, 1, 1, 1, 0, 1, 1},
                {1, 1, 2, 1, 3, 1, 1, 1, 1, 1, 2, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 1, 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 3, 1},
                {1, 1, 2, 1, 2, 1, 1, 1, 0, 0, 0, 2, 1, 1, 0, 2, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 2, 1, 3},
                {1, 0, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 0, 0},
                {1, 2, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 2, 2, 1}};

        //Names for the types
        String[] myTypeNamesArray = {"Normal", "Fighting", "Flying", "Poison", "Ground", 
                "Rock", "Bug", "Ghost", "Steel", "Fire", "Water", 
                "Grass", "Electric", "Psychic", "Ice", "Dragon", 
                "Dark", "Fairy"};


        //loops the message panes until they get a wrong answer
        for(int i = 0; i > -1; i++){

            //Two integers to randomly select one of the 18 different types
            int num1 = (int)(Math.random()*18);
            int num2 = (int)(Math.random()*18);

            //Creates JOptionPane to show the two randomed types and get input
            //Name of the buttons
            Object[] buttons = { "Not Very Effective", "Neutral", "Super Effective", "No Damage" };

            //Test output for asking them how effective type 1 is vs type 2
            System.out.println(num1 + " " + num2 + " " + "How effective is " + 
                    myTypeNamesArray[num1] + " against " + myTypeNamesArray[num2] + "?    " + 
                    "the answer was " + (String)buttons[myTypeArray[num1][num2]] + ".   " + i);

            // **HERE IS WHERE THE MESSAGE IS BLANK SOMETIMES**
            int answer = JOptionPane.showOptionDialog(null, "How effective is " + 
                    myTypeNamesArray[num1] + " against " + myTypeNamesArray[num2] + "?",
                    "Pokemon Type Effectiveness Quiz", JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[0]);


            //Test their answers                     
            if(answer == myTypeArray[num1][num2]){
            } else if(!(answer == myTypeArray[num1][num2])) {
                // **THIS IS ALSO BLANK SOMETIMES **
                JOptionPane.showMessageDialog(null, "Sorry, the answer was " + 
                        (String)buttons[myTypeArray[num1][num2]] + ". You said " + 
                        buttons[answer] + "\nYou got " + i + " correct.");
                break;
            } else {
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }

}