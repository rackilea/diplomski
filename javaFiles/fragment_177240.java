import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

class QuiltPanel extends JPanel {
    int x = 0, y = 0;
    int rowCount = 7;
    int columnCount = 5;

    private QuiltPattern squareOne, squareTwo;

    public QuiltPanel() {
        squareOne = new QuiltPattern(25, Color.blue);
        squareTwo = new QuiltPattern(25, Color.green);

        setPreferredSize(new Dimension(750, 500));
        setBackground(Color.black);

    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        int count = 0;
        int squareSide = squareOne.getWidth();
        boolean firstOne = true;

        int quiltWidth = columnCount * squareSide;
        int quiltHeight = rowCount * squareSide;

        int initX = (getWidth() - quiltWidth) / 2;
        int initY = (getHeight() - quiltHeight) / 2;

            for(int colJ = 0; colJ < columnCount; colJ++) {
                for(int rowI = 0; rowI < rowCount; rowI++) {
                    int x = colJ * squareSide + initX;
                    int y =  rowI * squareSide + initY;
                    if(firstOne) {
                        squareOne.draw(page, x, y);
                    } else {
                        squareTwo.draw(page, x, y);
                    }
                    firstOne = !firstOne;
                }
            }
    }
}