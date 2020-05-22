import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
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
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class DragAndDropTest {

    public static void main(String[] args) {
        new DragAndDropTest();
    }

    public DragAndDropTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridLayout(1, 2));
            add(new DropPane());
            add(new DragPane());
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

    public class DragPane extends JPanel {

        private DragSource ds;
        private Transferable transferable;

        public DragPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    setCursor(Cursor.getDefaultCursor());
                }
            });
            ds = new DragSource();
            transferable = new Transferable() {

                @Override
                public DataFlavor[] getTransferDataFlavors() {
                    return new DataFlavor[]{DataFlavor.stringFlavor};
                }

                @Override
                public boolean isDataFlavorSupported(DataFlavor flavor) {
                    return DataFlavor.stringFlavor.equals(flavor);
                }

                @Override
                public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                    return "This is a test";
                }
            };
            ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, new DragGestureListener() {
                @Override
                public void dragGestureRecognized(DragGestureEvent dge) {
                    // This is where you would export the data you want
                    // to transfer
                    ds.startDrag(dge, Cursor.getPredefinedCursor(Cursor.HAND_CURSOR), transferable, new DragSourceListener() {

                        @Override
                        public void dragEnter(DragSourceDragEvent dsde) {
                        }

                        @Override
                        public void dragOver(DragSourceDragEvent dsde) {
                        }

                        @Override
                        public void dropActionChanged(DragSourceDragEvent dsde) {
                        }

                        @Override
                        public void dragExit(DragSourceEvent dse) {
                        }

                        @Override
                        public void dragDropEnd(DragSourceDropEvent dsde) {
                            setCursor(Cursor.getDefaultCursor());
                        }

                    });
                }
            });

            setLayout(new GridBagLayout());
            add(new JLabel("Drag from here"));
            setBorder(new LineBorder(Color.RED));
        }

    }

    public class DropPane extends JPanel {

        private List<Point> dropPoints;

        public DropPane() {
            dropPoints = new ArrayList<>(25);
            setDropTarget(new DropTarget(this, new DropTargetListener() {

                @Override
                public void dragEnter(DropTargetDragEvent dtde) {
                }

                @Override
                public void dragOver(DropTargetDragEvent dtde) {
                }

                @Override
                public void dropActionChanged(DropTargetDragEvent dtde) {
                }

                @Override
                public void dragExit(DropTargetEvent dte) {
                }

                @Override
                public void drop(DropTargetDropEvent dtde) {
                    // Normally here, I'd inspect the Transferable and make sure
                    // what is been dropped and can be imported, I'd then go through
                    // the process of unwrapping the data from the Transferable and 
                    // processing it appropriatly, but in this example, I really don't
                    // care, I just care about WHERE the event occured
                    dropPoints.add(dtde.getLocation());
                    dtde.dropComplete(true);
                    repaint();
                }
            }));
            setLayout(new GridBagLayout());
            add(new JLabel("Drop to here"));
            setBorder(new MatteBorder(1, 1, 1, 0, Color.RED));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            for (Point p : dropPoints) {
                g.fillOval(p.x - 2, p.y - 2, 5, 5);
            }
        }

    }

}