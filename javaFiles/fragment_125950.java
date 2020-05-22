import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Zap extends JPanel {

    private static final long serialVersionUID = 330L;

    String[][] equations = new String[][]{
            //                  {"Line ----------------------","3 t-1","t+1"},
            {"Line","3 t-1","t+1"},
            {"Circle","cos(t)","sin(t)","-pi","pi"},
            {"Sq Circle","cos(t)","2 sin(t)","-pi","pi"},
            {"Ellipse","2 cos(t)","sin(t)","-pi","pi"},
            {"Cycloid","t-sin(t)","1-cos(t)","-20","20"},
            {"---- Hypocycloids ----"},
            {"Deltoid","2 cos(t)+cos(2t)","2 sin(t)-sin(2t)","-pi","pi"},
            {"Astroid","cos(t)^3","sin(t)^3","-pi","pi"},
            {"Hypocycloids 5","cos(t) + cos(4 t)/4","sin(t) - sin(4 t)/4","-pi","pi" },
            {"---- Epicycloids ----"},
            {"Cardioid",
                "cos(t) - cos(2 t)/2",
                "sin(t) - sin(2 t)/2","-pi","pi" },
                {"Nephroid",
                    "cos(t) - cos(3 t)/3",
                    "sin(t) - sin(3 t)/3","-pi","pi" },
                    {"Epicycloid 3",
                        "cos(t) - cos(4 t)/4",
                        "sin(t) - sin(4 t)/4","-pi","pi" },
                        {"Epicycloid 4",
                            "cos(t) - cos(5 t)/5",
                            "sin(t) - sin(5 t)/5","-pi","pi" },
                            {"Epicycloid 4",
                                "cos(t) - cos(5 t)/5",
                                "sin(t) - sin(5 t)/5","-pi","pi" },
                                {"Epicycloid 5",
                                    "cos(t) - cos(6 t)/6",
                                    "sin(t) - sin(6 t)/6","-pi","pi" },

                                    {"---- Lissajous curves ----","t","t","1","1"}, // commenting this line
                                    {"Lissajous 1,2","sin(t)","sin(2 t)","-pi","pi"},
                                    {"Lissajous 1,3","sin(t-pi/2)","sin(3 t)","-pi","pi"},
                                    {"Lissajous 1,4","sin(t)","sin(4 t)","-pi","pi"},//             {"a Lissajousxxxxxxxxxxb",""},
                                    {"Lissajous 2,1","sin(2t)","sin(t)","-pi","pi"},
                                    {"Lissajous 2,2","sin(2t-pi/4)","sin(2t)","-pi","pi"},
                                    {"Lissajous 2,3","sin(2t-pi/3)","sin(3t)","-pi","pi"},
                                    {"Lissajous 3,4","sin(3t)","sin(4t)","-pi","pi"},
    };

    /** The canvas for plotting the graph */
    private JPanel graphCanvas;

    DefaultListModel model = new DefaultListModel(); 
    /** List of equations */
    JList list = new JList(model);

    /**
     * Initializes the FunctionPlotter
     */
    public void init ()  {
        try {
            initComponents();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Sets the layout of the applet window to BorderLayout, creates all
     * the components and associates them with event listeners if necessary.
     * @param j
     * @throws JepException
     */
    private void initComponents ()  {
        setLayout(new BorderLayout());
        System.out.println("list "+list.getBounds());
        System.out.println("list ps"+list.getPreferredSize());
        list.setVisibleRowCount(8);
        JScrollPane scroll = new JScrollPane(
                list, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
                );
        add(BorderLayout.LINE_END,scroll);

        for(String[] eles:equations) {
            model.addElement(eles[0]);
        }

        // create the graph canvas and add it
        graphCanvas = createGraphCanvas();
        //add (graphCanvas,gbc1);
        add("Center",graphCanvas);
    }

    protected JPanel createGraphCanvas()  {
        JPanel gc = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GREEN.darker());
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        gc.setPreferredSize(new Dimension(300,10));
        return gc;
    }

    public static void main(String argv[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    protected static void createAndShowGUI() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Zap pp = new Zap();
        f.add(pp);
        pp.init();
        System.out.println("pack");
        f.pack();
        System.out.println("setVis");
        f.setVisible(true);
        System.out.println("setVis done");
    }
}