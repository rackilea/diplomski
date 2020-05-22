import javax.swing.*;
import java.awt.*;

public class SquareButtonsTestApp extends JFrame {

    public static void main ( String[] args ) {
        new SquareButtonsTestApp();
    }

    public SquareButtonsTestApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new MyGridLayout(10, 20));
        for (int i=0; i<10; i++) {
            for (int j=0; j<20; j++) {
                getContentPane().add(new JButton(" "));
            }
        }
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    class MyGridLayout extends GridLayout {
        public MyGridLayout(int rows, int cols) {
            super(rows, cols);
        }
        public void layoutContainer(Container parent) {
            synchronized (parent.getTreeLock()) {
                Insets insets = parent.getInsets();
                int ncomponents = parent.getComponentCount();
                int nrows = getRows();
                int ncols = getColumns();
                boolean ltr = parent.getComponentOrientation().isLeftToRight();

                if (ncomponents == 0) {
                    return;
                }
                if (nrows > 0) {
                    ncols = (ncomponents + nrows - 1) / nrows;
                } else {
                    nrows = (ncomponents + ncols - 1) / ncols;
                }
                // 4370316. To position components in the center we should:
                // 1. get an amount of extra space within Container
                // 2. incorporate half of that value to the left/top position
                // Note that we use trancating division for widthOnComponent
                // The reminder goes to extraWidthAvailable
                int totalGapsWidth = (ncols - 1) * getHgap();
                int widthWOInsets = parent.getWidth() - (insets.left + insets.right);
                int widthOnComponent = (widthWOInsets - totalGapsWidth) / ncols;
                int extraWidthAvailable = (widthWOInsets - (widthOnComponent * ncols + totalGapsWidth)) / 2;

                int totalGapsHeight = (nrows - 1) * getVgap();
                int heightWOInsets = parent.getHeight() - (insets.top + insets.bottom);
                int heightOnComponent = (heightWOInsets - totalGapsHeight) / nrows;
                int extraHeightAvailable = (heightWOInsets - (heightOnComponent * nrows + totalGapsHeight)) / 2;

                int size=Math.min(widthOnComponent, heightOnComponent);
                widthOnComponent=size;
                heightOnComponent=size;
                if (ltr) {
                    for (int c = 0, x = insets.left + extraWidthAvailable; c < ncols ; c++, x += widthOnComponent + getHgap()) {
                        for (int r = 0, y = insets.top + extraHeightAvailable; r < nrows ; r++, y += heightOnComponent + getVgap()) {
                            int i = r * ncols + c;
                            if (i < ncomponents) {
                                parent.getComponent(i).setBounds(x, y, widthOnComponent, heightOnComponent);
                            }
                        }
                    }
                } else {
                    for (int c = 0, x = (parent.getWidth() - insets.right - widthOnComponent) - extraWidthAvailable; c < ncols ; c++, x -= widthOnComponent + getHgap()) {
                        for (int r = 0, y = insets.top + extraHeightAvailable; r < nrows ; r++, y += heightOnComponent + getVgap()) {
                            int i = r * ncols + c;
                            if (i < ncomponents) {
                                parent.getComponent(i).setBounds(x, y, widthOnComponent, heightOnComponent);
                            }
                        }
                    }
                }
            }
        }
    }
}