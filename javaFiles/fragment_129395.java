import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawPanel extends JPanel implements MouseListener {

    private static final long serialVersionUID = -7726303639184194659L;

// begin members
    private DrawLines dlines;
    private DrawPoints dpoints;

    // dont know what these members do
    private Point p1 = new Point(100, 100);
    public int Xpoint[][] = new int[500][30];
    public int Ypoint[][] = new int[500][30];
    private double Xmpoint[][] = new double[500][1000]; // [i
                                                        // γραμμή][συντεταγμένη
                                                        // Χ]
    private double Ympoint[][] = new double[500][1000];

    private double Vec[][][] = new double[500][2][500]; // [i γραμμή][0,1][0α
                                                        // 1β]

    private double dist[] = new double[10000];
    private boolean drawing;
    private int c1;
    private int c2;
// end members

    public DrawPanel() {
        dlines = new DrawLines();
        dpoints = new DrawPoints();

        addMouseListener(this);
    }

// begin class logic
    public void clearLines(){
        dlines.clearLines();
        repaint();
    }


    // dont know what this does
    public void createmesh() {
        int mdi = 0;

        for (int j = 0; j <= c2; j++) {
            for (int i = 0; i < c1 - 1; i++) {

                // Υπολογισμός a και b συνιστωσών της εξίσωσης της γραμμής

                Vec[i][0][mdi] = (Ypoint[i + 1][j] - Ypoint[i][j])
                        / (Xpoint[i + 1][j] - Xpoint[i][j]);
                Vec[i][1][mdi] = Ypoint[i][j] - Xpoint[i][j] * Vec[i][1][mdi];

                // Υπολογισμός μέτρου διανύσματος

                dist[mdi] = Math.sqrt(Math.pow(Xpoint[i][j] - Xpoint[i + 1][j],
                        2) + Math.pow(Ypoint[i][j] - Ypoint[i + 1][j], 2));

                // Υπολογισμός ενδιάμεσον σημείων

                int nkom = 3;
                double xa = Xpoint[i][j];
                double ya = Ypoint[i][j];

                for (int ii = 0; ii < nkom; ii++) {
                    double a = Vec[i][0][mdi];
                    double b = Vec[i][1][mdi];

                    Xmpoint[i][ii] = (-((2 * a) * (b - ya) - 2 * xa) + Math
                            .sqrt(Math.abs(Math.pow(
                                    ((2 * a) * (b - ya) - 2 * xa), 2)
                                    - 4
                                    * (1 + a * a)
                                    * (xa * xa + Math.pow((b - ya), 2) - Math
                                            .pow(dist[mdi] / nkom, 2)))))
                            / (2 + 2 * a * a);

                    Ympoint[i][ii] = a * Xmpoint[i][ii] + b;

                    double xm11 = Xmpoint[i][ii];
                    double ym11 = Ympoint[i][ii];
                    int xm1 = (int) xm11;
                    int ym1 = (int) ym11;

                    dpoints.addPoint(xm1, ym1);

                    System.out.println("i:" + ym11 + "...ii:" + ym1);

                    xa = Xmpoint[i][ii];
                    ya = Ympoint[i][ii];
                }

                mdi++;

            }
        }
    }
// end class logic

// begin MouseListener implementation
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isRightMouseButton(e)) {
            drawing = false;
            c2++;

        }
        if (SwingUtilities.isLeftMouseButton(e)) {
            p1 = e.getPoint();
            Xpoint[c1][c2] = p1.x;
            Ypoint[c1][c2] = p1.y;

            if (c1 > 3) {

                for (int j = 0; j < c2 + 1; j++) {
                    for (int i = 0; i < c1; i++) {

                        if ((Math.abs(Xpoint[i][j] - Xpoint[c1][c2]) < 10)
                                && (Math.abs(Ypoint[i][j] - Ypoint[c1][c2]) < 10)) {

                            Xpoint[c1][c2] = Xpoint[i][j];
                            Ypoint[c1][c2] = Ypoint[i][j];
                            System.out.println(Xpoint[i][j]);

                        }
                    }
                }
            }

            if (drawing == true) {
                dlines.addLine(Xpoint[c1][c2], Ypoint[c1][c2],
                        Xpoint[c1 - 1][c2], Ypoint[c1 - 1][c2]);
            }

            c1++;
            drawing = true;

            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
// end MouseListener implementation

// beging PAINTING
    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("paintComponent");
        super.paintComponent(g);

        dlines.draw(g);
        dpoints.draw(g);
    }
// end PAINTING
}