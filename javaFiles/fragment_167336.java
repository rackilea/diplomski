import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

class DragDropExample {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            final JFrame frame = new JFrame("JLabel Text Example");

            final JTable table = new JTable(new DefaultTableModel(
                    new Object[][] {
                            {"Item 1"},
                            {"Item 2"},
                            {"Item 3"},
                            {"Item 4"},
                            {"Item 5"}},
                    new String[] {"Column Name"}));
            table.setDragEnabled(true);
            table.setDropTarget(new DropTarget() {

                @Override
                public synchronized void drop(DropTargetDropEvent dtde) {
                    try {
                        // get row to put new item in
                        int row = table.rowAtPoint(dtde.getLocation());
                        // inserting row:
                        ((DefaultTableModel) table.getModel()).insertRow(
                                //if the row wasn't found, add it to the end of the JTable
                                row == -1 ? table.getRowCount() : row,
                                // pass string flavor of transferable data as row data parameter
                                new Object[] {dtde.getTransferable()
                                        .getTransferData(DataFlavor.stringFlavor)});
                    } catch(UnsupportedFlavorException | IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            final JLayeredPane layeredPane = new JLayeredPane() {

                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(200, 300);
                }

            };
            layeredPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            layeredPane.setLayout(new BoxLayout(layeredPane, BoxLayout.Y_AXIS));
            layeredPane.setDropTarget(new DropTarget() {

                @Override
                public synchronized void drop(DropTargetDropEvent dtde) {
                    try {
                        // create draggable label to add to layered pane
                        // creating this class will be explained next
                        final DraggableLabel label = new DraggableLabel(
                                (String) dtde.getTransferable()
                                        .getTransferData(DataFlavor.stringFlavor));

                        // add label to layered pane
                        layeredPane.add(label, JLayeredPane.DEFAULT_LAYER);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    } catch(UnsupportedFlavorException | IOException e) {
                        e.printStackTrace();
                    }
                }

            });

            frame.getContentPane().add(table, BorderLayout.WEST);
            frame.getContentPane().add(layeredPane);
            frame.pack();
            frame.setLocationByPlatform(true);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class DraggableLabel extends JLabel implements DragGestureListener, DragSourceListener {

        private DragSource dragSource;

        DraggableLabel(String text) {
            super(text);

            // create the drag source
            dragSource = new DragSource();
            // assign this component a DragGestureRecognizer
            dragSource.createDefaultDragGestureRecognizer(
                    this, DnDConstants.ACTION_COPY_OR_MOVE, this);

            // for contrast with other items
            setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        }

        @Override
        public void dragGestureRecognized(DragGestureEvent evt) {
            dragSource.startDrag(
                    evt, //trigger event
                    DragSource.DefaultMoveDrop,
                    new StringSelection(getText()),
                    this);
        }

        @Override
        public void dragEnter(DragSourceDragEvent evt) {}

        @Override
        public void dragOver(DragSourceDragEvent evt) {}

        @Override
        public void dragExit(DragSourceEvent evt) {}

        @Override
        public void dropActionChanged(DragSourceDragEvent evt) {}

        @Override
        public void dragDropEnd(DragSourceDropEvent evt) {}

    }

}