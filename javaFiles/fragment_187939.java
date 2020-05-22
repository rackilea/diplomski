import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class MyTestPanel extends JPanel {
    final int LINE_HEIGHT = 20;
    final int START_X = 20;
    final int START_Y = 20;
    //private int lastLineY;

    final List<String> lines = new ArrayList<String>();
    final StringBuilder lastLine = new StringBuilder();
    private JScrollPane parentPane;
    //Thread cursorThread;
    //private AtomicBoolean keepRunningCursor = new AtomicBoolean(true);

    String validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,.\\/:;<=>?@[] ^_`{|}~-]*$";

    /*public static void main(String[] args) throws Exception {
        TestFrame2.main(null);
    }*/

    public MyTestPanel() {
        //setPreferredSize(new Dimension(700, 300));
        this.setFocusable(true);
        this.setBackground(Color.WHITE);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (isPrintableChar(ch)) {
                    lastLine.append(ch);
                    repaint();
                } else if (ch == '\b') {
                    if (lastLine.length() > 0) {
                        lastLine.deleteCharAt(lastLine.length() - 1);
                        repaint();
                    }
                } else if (ch == '\n') {
                    lines.add(lastLine.toString());
                    lastLine.delete(0, lastLine.length());
                    repaintAndUpdate();
                }
                updateScrollbar();
                System.out.println("textContent " + lastLine);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    System.out.println("BackSpace pressed");
                }
            }
        });
    }

    public void updateScrollbar() {
        if (parentPane != null) {
            JScrollBar vertical = parentPane.getVerticalScrollBar();
            System.out.println(vertical.getMaximum() + " : " + parentPane.getHeight() + " : " + (vertical.getMaximum() - parentPane.getHeight()) + " : " + vertical.getHeight());
            vertical.setValue(vertical.getMaximum() - parentPane.getHeight() + parentPane.getHorizontalScrollBar().getHeight());
        }
    }
    private void repaintAndUpdate() {
        int linesHeight = START_Y + lines.size() * LINE_HEIGHT + LINE_HEIGHT;//+LINE_HEIGHT just trial and error
        if(linesHeight > parentPane.getHeight()) {
            System.out.println(getHeight() + " : " + (getHeight() + LINE_HEIGHT));
            super.setPreferredSize(new Dimension(getWidth(), getHeight() + LINE_HEIGHT) );
            parentPane.updateUI();
            super.revalidate();
            System.out.println(getHeight());

            repaint();
        }
    }

    private boolean isPrintableChar(char ch) {
        boolean result = false;
        if (validCharacters.indexOf(ch) != -1) {
            result = true;
        }
        return result;
    }

    /*public void startCursorThread() {
        final Graphics g = this.getGraphics();
        final int blinkInterval = 500;//miliseconds
        final int cursorWidth = 5;
        final int cursorHeight = LINE_HEIGHT;

        cursorThread = new Thread () {
            public void run () {
                boolean showCursor = true;
                while(keepRunningCursor.get()) {
                    localSleep(blinkInterval);
                    int x = START_X + g.getFontMetrics().stringWidth(lastLine.toString());
                    //int y = START_Y + lines.size() * LINE_HEIGHT - LINE_HEIGHT + LINE_HEIGHT/3;
                    int y = lastLineY - (int)(2/3.0 * LINE_HEIGHT);
                    if(showCursor) {
                        g.fillRect(x, y, cursorWidth, cursorHeight);
                        g.drawRect(x - 50, y - 50, 100, 100);
                    } else {
                        g.setColor(Color.WHITE);
                        g.fillRect(x, y, cursorWidth, cursorHeight);
                        g.drawRect(x - 50, y - 50, 100, 100);
                        g.setColor(Color.BLACK);
                    }
                    showCursor = !showCursor;

                    System.out.printf("%d %d %d %d\n", x, y, cursorWidth, cursorHeight);
                    //MyTestPanel.this.repaint(x, y, cursorWidth, cursorHeight);
                }

            }

            public void localSleep(long sleepTime) {
                try {
                    sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };

        cursorThread.start(); 
    }*/

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = START_Y;
        for (int i = 0; i < lines.size(); i++, y += LINE_HEIGHT) {
            g.drawString(lines.get(i), START_X, y);
        }
        if (lastLine.length() > 0) {
            g.drawString(lastLine.toString(), START_X, y);
        }
        int x = START_X + g.getFontMetrics().stringWidth(lastLine.toString());
        //cursor
        g.fillRect(x + 2, y - (int)(2/3.0 * LINE_HEIGHT), 5, 20);
        //lastLineY = y;
    }

    public void setParentPane(JScrollPane parentPane) {
        this.parentPane = parentPane;
        setPreferredSize(new Dimension(parentPane.getWidth(), parentPane.getHeight()));
    }

    /*public void stopCursorThread() {
        this.keepRunningCursor.set(false);
        System.out.println("Stopped cursor thread");
    }*/
}