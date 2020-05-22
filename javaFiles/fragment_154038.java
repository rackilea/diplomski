import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;


public class PanelPlay
{
  JFrame windowContainer; 
  JPanel rightWindow;
  JPanel rightWindowMaximumWidth;
  private BoxLayout rightWindowSplit;
  private JPanel rightUp;
  private JTextArea rightUpTextArea;
  private JScrollPane rightUpScrollPane;
  private JPanel rightDownBoxPanel;
  private BoxLayout rightDownBox;
  private JTextArea rightDownTextArea;
  private JScrollPane rightDownTextAreaScrollPane;
  private JButton rightDownButtomSend;

  public static void main(String ... arguments)
  {
    PanelPlay pp = new PanelPlay();
    pp.go();
  }

  public void go()
  {
    windowContainer = new JFrame();
    setupRightSide();
    windowContainer.pack();
    windowContainer.setVisible(true);
  }

  private void setupRightSide(){
    //rightWindow
    rightWindow             = new JPanel(new BorderLayout(10,10));
    rightWindowMaximumWidth = new JPanel();
    rightWindowSplit        = new BoxLayout(rightWindowMaximumWidth, BoxLayout.Y_AXIS);//"rightWindow" is the parent, not "windowContainer"!!!

    rightUp                 = new JPanel();
    rightUpTextArea         = new JTextArea();
    rightUpScrollPane       = new JScrollPane(rightUpTextArea);

    rightDownBoxPanel       = new JPanel();
    rightDownBox            = new BoxLayout(rightDownBoxPanel, BoxLayout.X_AXIS);//"rightDownBoxPanel" is the parent, not "rightWindow"!!!
    rightDownTextArea       = new JTextArea();
    rightDownTextAreaScrollPane = new JScrollPane(rightDownTextArea);
    rightDownButtomSend     = new JButton("Send");

    //rightUpScrollPane.setAutoscrolls(true);

    windowContainer.add(rightWindow, BorderLayout.CENTER);

    //rechte Seite
    rightWindow.setPreferredSize(new Dimension(250,250));
    rightWindow.setSize(new Dimension(424,503));  // habe ich durch datenausgabe mit der Konsole herrausgefundem
    rightWindow.add(rightWindowMaximumWidth, BorderLayout.CENTER);

    //container in "rechte Seite" mit maximaler width von 1000px
    rightWindowMaximumWidth.setLayout(rightWindowSplit);
    rightWindowMaximumWidth.setPreferredSize(new Dimension(rightWindow.getWidth()-10,1000));
    rightWindowMaximumWidth.setMaximumSize(new Dimension(1000,Integer.MAX_VALUE));

    rightWindowMaximumWidth.add(rightUpScrollPane, "Up");
    rightWindowMaximumWidth.add(Box.createRigidArea(new Dimension(0,10)));
    rightWindowMaximumWidth.add(rightDownBoxPanel, "Down");
    rightWindowMaximumWidth.add(Box.createRigidArea(new Dimension(0,10)));

    setupRechtsOben();
    setupRechtsUnten();

}

private void setupRechtsOben(){
    //obere Teil der rechten Seite
    rightUp.setPreferredSize(new Dimension(420 , 400));
    rightUp.setMaximumSize(new Dimension(420,400));
   // rightUp.add(rightUpScrollPane);

    //TextFeld rechts-oben
    rightUpTextArea.setBorder( new CompoundBorder(new javax.swing.border.LineBorder(Color.BLACK), new EmptyBorder(15, 15, 15, 15)));
    rightUpTextArea.setEditable(false);
    rightUpTextArea.setLineWrap(true);
    rightUpTextArea.setWrapStyleWord(true);
    rightUpTextArea.setBackground(Color.lightGray);
    rightUpTextArea.setPreferredSize(new Dimension(420,350));//-2 damit der rand zu sehen ist
    rightUpTextArea.setMaximumSize(rightWindowMaximumWidth.getMaximumSize());
    rightUpTextArea.setText("d\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\nd\n"); //to fill it with text


}

private void setupRechtsUnten(){
    //untere Teil der rechten Seite (vertikales BoyLayout)
    rightDownBoxPanel.setLayout(rightDownBox);
    rightDownBoxPanel.add(rightDownTextAreaScrollPane, "TextField");
    rightDownBoxPanel.add(Box.createRigidArea(new Dimension(10,0)));
    rightDownBoxPanel.add(rightDownButtomSend, "SendButton");
    rightDownBoxPanel.setMaximumSize(new Dimension(1000,100));
    rightDownBoxPanel.setPreferredSize(new Dimension(1000 ,100));


    //TextEingabe im BoxLayout
    rightDownTextArea.setBorder(new javax.swing.border.LineBorder(Color.BLACK));
    //Damit es in der nächsten Zeile weitergeht, wenn diese voll ist
    rightDownTextArea.setLineWrap(true);
    rightDownTextArea.setWrapStyleWord(true);

    //SendButton im BoxLayout
    rightDownButtomSend.setSize(new Dimension(100, 50));
    rightDownButtomSend.setPreferredSize(new Dimension(100, 50));
    rightDownButtomSend.setMaximumSize(new Dimension(100, 50));
    rightDownButtomSend.setFont(new Font("Arial", Font.BOLD, 14));
    rightDownButtomSend.setAlignmentX(JFrame.CENTER_ALIGNMENT);

}
}