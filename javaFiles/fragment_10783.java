public class SwimingPoolCalculator implements ChangeListener {

    private JFrame frame;
    private JPanel primaryJPanel, drawingJPanel;
    private JLabel deepJLabel, shallowJLabel;
    private JSlider deepJSlider, shallJSlider;
    private JTextField resultTextField;

    final private int xPos = 20;
    final private int yPos = 20;
    final private int swimmingPoolLength = 200;
    final private int swimmingPoolWidth = 50;
    private int deepEnd;   // <== moved to fields
    private int shallowEnd;  // <== moved to fields

    private class InnerDrawingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics drawingBoard) {
            drawingBoard.setColor(Color.yellow);   // <== drawing code now here
            drawingBoard.fillRect(0, 0, 250, 250);
            drawingBoard.setColor(Color.black);

            drawingBoard.drawLine(xPos, yPos, xPos + swimmingPoolLength, yPos);  // the top line
            drawingBoard.drawLine(xPos, yPos, xPos, yPos + deepEnd); // the left line
            drawingBoard.drawLine(xPos + swimmingPoolLength, yPos, xPos + swimmingPoolLength, yPos + shallowEnd); // the right line
            drawingBoard.drawLine(xPos, yPos + deepEnd, xPos + swimmingPoolLength, yPos + shallowEnd); // the bottom line
        }
    }

    public static void main(String[] args) {

        SwimingPoolCalculator swimingPoolCalculator = new SwimingPoolCalculator();

        swimingPoolCalculator.createGUI();

    }

    private void createGUI(){

        frame = new JFrame("Swiming Pool Calculator");

        primaryJPanel = new JPanel();
        primaryJPanel.setPreferredSize(new Dimension(250, 500));

        drawingJPanel = new InnerDrawingPanel();  // <== use inner class
        drawingJPanel.setPreferredSize(new Dimension(250, 300));
        drawingJPanel.setBackground(Color.yellow);

        shallowJLabel = new JLabel("S End");
        deepJLabel = new JLabel("D End");

        shallJSlider = new JSlider(JSlider.HORIZONTAL, 10, 100, 10);
        deepJSlider = new JSlider(JSlider.HORIZONTAL, 50, 200, 100);

        shallJSlider.addChangeListener(this);
        deepJSlider.addChangeListener(this);

        resultTextField = new JTextField(15);

        primaryJPanel.add(drawingJPanel);
        primaryJPanel.add(shallowJLabel);
        primaryJPanel.add(shallJSlider);
        primaryJPanel.add(deepJLabel);
        primaryJPanel.add(deepJSlider);
        primaryJPanel.add(resultTextField);

        frame.getContentPane().add(primaryJPanel);
        frame.pack();
        frame.setVisible(true);

        // why the first call does not draw any line?
        shallowEnd = deepJSlider.getValue(); // <== now update fields
        deepEnd = shallJSlider.getValue();
        drawingJPanel.repaint();        // <== trigger repaint

    }


    private void calculateVolume(double averageDepth){

        int swimmingPoolVolume = (int)(averageDepth * swimmingPoolLength * swimmingPoolWidth);

        resultTextField.setText("Volume: " + swimmingPoolVolume);

    }

    @Override
    public void stateChanged(ChangeEvent e) {

        shallowEnd = shallJSlider.getValue();  // <== update fields
        deepEnd = deepJSlider.getValue();

        double averageDepth = (shallowEnd + deepEnd) / 2;


        drawingJPanel.repaint();   // <== trigger repaint
        calculateVolume(averageDepth);

    }

}