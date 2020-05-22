import java.awt.*;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;


public class TransparencyDemo extends Box{

    protected JPanel pGradientPane;

    //Interface gradient specification
    private Color pInterfaceColour = new Color(255, 245, 62);
    protected int iDegreeWhite = 180;
    protected int iDegreeBlack = 0;

    public TransparencyDemo() {
        super(BoxLayout.X_AXIS);
        setOpaque(true);

        //Incorrect Solution
        pGradientPane = new JPanel(new GridBagLayout())
        {
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics pGraphics) 
            {
                Graphics2D pGraphicsGradientRender = (Graphics2D) pGraphics;
                pGraphicsGradientRender.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint pGradient = new GradientPaint(0, 0, new Color(255, 255, 255, iDegreeWhite), 0, getHeight(), new Color(0, 0, 0, iDegreeBlack));
                pGraphicsGradientRender.setPaint(pGradient);
                pGraphicsGradientRender.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(pGraphics);
            }
        };
        pGradientPane.setOpaque(false);
        add(pGradientPane);

        //Correct Solution
        JPanel pGradientPane2 = new JPanel(new GridBagLayout())
        {
            private static final long serialVersionUID = 1L;

            protected void paintComponent(Graphics pGraphics) 
            {
                Graphics2D pGraphicsGradientRender = (Graphics2D) pGraphics;
                pGraphicsGradientRender.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint pGradient = new GradientPaint(0, 0, new Color(255, 255, 255, iDegreeWhite), 0, getHeight(),  new Color(255, 245, 62, iDegreeWhite));
                pGraphicsGradientRender.setPaint(pGradient);
                pGraphicsGradientRender.fillRect(0, 0, getWidth(), getHeight());
                super.paintComponent(pGraphics);
            }
        };
        pGradientPane2.setOpaque(false);
        add(pGradientPane2);


        setBackground(pInterfaceColour);

    }

    public static void main(String[] args){
        try {
             for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                   UIManager.setLookAndFeel(info.getClassName());
                   break;
                }
             }
          } catch (Exception e) {
             e.printStackTrace();
          }

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TransparencyDemo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}