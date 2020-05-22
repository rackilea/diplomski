final String score  = ReadIt.readLine();  
final String score1 = ReadIt.readLine();
SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        GraphicGameBoard.topScoreDisplay.setText(score  + "\n");
        GraphicGameBoard.topScoreDisplay.setText(score1 + "\n");
    }
});