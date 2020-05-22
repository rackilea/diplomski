public class StudentGradesView extends FrameView {
 final static int students=15;
 final static int numOfTest=4;

 //Start with the first student in the 2D array
 private int row = 0;


//DELCARING THE 2D ARRAY
double[][] marks = new double[students][numOfTest];


public void addInfo(){
    double testScores[]=new double[4];
    testScores[0]=Double.parseDouble(testOneIn.getText());
    testScores[1]=Double.parseDouble(testTwoIn.getText());
    testScores[2]=Double.parseDouble(testThreeIn.getText());
    testScores[3]=Double.parseDouble(testFourIn.getText());

    //Add all four test scores to the current student
        for(int col=0;col < testScores.length; col++){
            marks[row][col]= testScores[col];
            }

    //Advance to the next student
    row++;
   }
  }