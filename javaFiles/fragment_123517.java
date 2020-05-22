//MAKES LOADING SCREEN
JFrame f = new JFrame("Loading...");
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Container content = f.getContentPane();
JProgressBar progressBar = new JProgressBar();
progressBar.setStringPainted(true);
Border border = BorderFactory.createTitledBorder("Calcualating...");
progressBar.setBorder(border);
content.add(progressBar, BorderLayout.NORTH);
f.setSize(300, 100);
f.setVisible(true);

double percent = 0;
int intPercent = 0;
progressBar.setValue(intPercent);
//Calculates Pi
for (i = 1.0; i <= iterations; i++)
{
    stage = stage + y/x;
    y = - y; //Flips Sign
    x+=2; 
    //CALCULATE PERCENT COMPLETE
    percent = 100*(i/iterations);
    intPercent = (int) (percent + 0.5); //Adds .5 in order to round.
    progressBar.setValue(intPercent);
    //STOP CALCULATING PERCENT COMPLETE
}

myPi = 4*stage;
System.out.println("My Pi: " + myPi);
//STOP CALCULATING PI