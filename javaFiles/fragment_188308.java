public class TestPane extends JPanel {

    private int currenAction;

    public TestPane() {
        String[] myShapesName = {"brushBut", "lineBut", "ellipseBut", "rectBut", "strokeBut", "fillBut"};
        //String[] myLisName = {"brushButL", "lineButL", "ellipseButL", "rectButL", "strokeButL", "fillButL"};

        setLayout(new GridLayout(3, 2));
        JButton[][] myShapes = new JButton[3][2];
        int action = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                myShapes[i][j] = new JButton();
                myShapes[i][j].setBounds(0, 0, 50, 50);//(100, 200);
                myShapes[i][j].setName(myShapesName[i + j]);
                myShapes[i][j].setBackground(null);
                myShapes[i][j].putClientProperty("id",
                        String.valueOf(myShapesName[i + j]).concat(String.valueOf(j)));

                myShapes[i][j].addActionListener(new ButtonAction(action));
                action++;
                add(myShapes[i][j]);
            }
        }
    }

    public class ButtonAction implements ActionListener {

        private int actionNum;

        public ButtonAction(int actionNum) {
            this.actionNum = actionNum;
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            currenAction = actionNum;
            System.out.println(actionNum);
        }

    }

}