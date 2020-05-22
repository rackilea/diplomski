import com.sun.lwuit.Button;
import com.sun.lwuit.Component;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.geom.Dimension;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.table.DefaultTableModel;
import com.sun.lwuit.table.Table;
import com.sun.lwuit.table.TableModel;
import javax.microedition.lcdui.Canvas;
import javax.microedition.midlet.MIDlet;

public class FixedTableDemo extends MIDlet implements ActionListener {

private static final String[] TITLES = {"Title 1", "Title 2", "Title 3", "Title 4", "Title 5"};
private static final int ROWS = 100;
private static Dimension[] TITLE_SIZES;
Button b[][];
int screenWidth;
int lastMove = 0;
int lastModifiedMove = 1;
int temp;

static class MirroredTable extends Table {

    private MirroredTable mirrorTo;

    public MirroredTable(TableModel m) {

        super(m);

    }

    public MirroredTable(TableModel m, boolean b) {

        super(m, b);

    }

    public void setScrollX(int x) {

        super.setScrollX(x);

        if (isDragActivated()) {

            mirrorTo.setScrollX(x);

        }

    }

    /**
     *
     * @param mirrorTo the mirrorTo to set
     *
     */
    public void setMirrorTo(MirroredTable mirrorTo) {

        this.mirrorTo = mirrorTo;

    }

    public Component createCell(Object value, int row, int column, boolean editable) {

        Component c = super.createCell(value, row, column, editable);

        if (TITLE_SIZES != null && TITLE_SIZES[column] != null) {

            c.setPreferredSize(TITLE_SIZES[column]);

        }

        return c;

    }
}
MirroredTable titlesTable;
MirroredTable bodyTable;

public void startApp() {

    Display.init(this);


    screenWidth = Display.getInstance().getDisplayWidth();

    Form f = new Form("Table Title");

    titlesTable = new MirroredTable(new DefaultTableModel(TITLES, new Object[0][0]));
    titlesTable.removeAll();

    Button bt[] = new Button[5];

    for (int i = 0; i < 5; i++) {
        bt[i] = new Button("Title" + (i + 10));
        bt[i].setUIID("");
        titlesTable.addComponent(bt[i]);
    }


    Object[][] body = new Object[ROWS][TITLES.length];

    bodyTable = new MirroredTable(new DefaultTableModel(TITLES, body), false);

    bodyTable.setMirrorTo(titlesTable);

    titlesTable.setMirrorTo(bodyTable);

    bodyTable.setScrollable(true);

    titlesTable.setScrollableX(true);

    f.setScrollable(false);

    f.setLayout(new BorderLayout());

    titlesTable.setTensileDragEnabled(false);

    bodyTable.setTensileDragEnabled(false);

    titlesTable.setIsScrollVisible(false);

    f.addComponent(BorderLayout.NORTH, titlesTable);

    f.addComponent(BorderLayout.CENTER, bodyTable);


    f.addGameKeyListener(Canvas.LEFT, this);
    f.addGameKeyListener(Canvas.RIGHT, this);
    f.addGameKeyListener(Canvas.UP, this);

    f.setCyclicFocus(false);


    /**
     * buttons adding and their listener
     */
    b = new Button[50][5];
    //Label l[][]=new Label[50][5];

    for (int i = 0; i < 50; i++) {
        for (int j = 0; j < 5; j++) {
            b[i][j] = new Button("Title" + (i + 10));
            b[i][j].setUIID("");
            //l[i][j]=new Label("Title 1");
            bodyTable.addComponent(b[i][j]);

        }
    }





    f.show();

}

public void actionPerformed(ActionEvent evt) {


    if (evt.getKeyEvent() == Canvas.LEFT) {
        if (lastMove != 0) {

            lastMove -= 20;

            bodyTable.setScrollX(lastMove);
            titlesTable.setScrollX(lastMove);
        }

    } else if (evt.getKeyEvent() == Canvas.RIGHT) {
        if (lastMove != lastModifiedMove) {

            lastMove += 20;


            bodyTable.setScrollX(lastMove);

            titlesTable.setScrollX(lastMove);

            if (temp == bodyTable.getScrollX()) {

                lastModifiedMove = temp;
                lastMove = temp;

            } else {
                temp = bodyTable.getScrollX();
            }

        } else {
            lastMove = lastModifiedMove;
        }
    } else if (evt.getKeyEvent() == Canvas.UP) {
    }
}

public void pauseApp() {
}

public void destroyApp(boolean unconditional) {
}
}