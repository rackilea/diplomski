import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class prognose extends JFrame {
  // Anfang Attribute
  private JTextField spendenbetrag = new JTextField();
  private JTextField streamzeit = new JTextField();
  private JLabel sBetragL = new JLabel();
  private JLabel sZeitL = new JLabel();
  private JButton prognosebutton = new JButton();
  private ImageIcon prognosebuttonIcon = new ImageIcon("C:\\test\\rak.png");
  private JTextField ergebnis = new JTextField();
  // Ende Attribute

  public prognose() { 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 455; 
    int frameHeight = 580;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Loot für die Welt");
    setResizable(false);
    JLabel background=new JLabel(new ImageIcon("C:\\test\\rak.png"));

    setContentPane(background);
    background.setLayout(new FlowLayout());
    Panel cp = new Panel(null);
    background.add(cp);

    // Anfang Komponenten

    spendenbetrag.setText("");
    background.add(spendenbetrag);
    streamzeit.setText("");
    background.add(streamzeit);
    sBetragL.setText("Aktueller Spendenbetrag");
    background.add(sBetragL);
    streamzeit.setBounds(152, 184, 145, 25);
    spendenbetrag.setBounds(152, 112, 145, 25);
    sBetragL.setBounds(152, 80, 145, 25);
    sZeitL.setBounds(152, 152, 155, 25);
    sZeitL.setText("Aktuelle Streamzeit");
    background.add(sZeitL);
    prognosebutton.setBounds(184, 224, 80, 280);
    prognosebutton.setText("");
    prognosebutton.setMargin(new Insets(2, 2, 2, 2));
    prognosebutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        prognosebutton_ActionPerformed(evt);
      }
    });
    prognosebutton.setIcon(prognosebuttonIcon);
    prognosebutton.setBorderPainted(false);
    prognosebutton.setBackground(Color.WHITE);
    prognosebutton.setBorder(BorderFactory.createEtchedBorder(0, Color.DARK_GRAY, new Color(0xC0C0C0)));
    prognosebutton.setIconTextGap(0);
    background.setBackground(Color.WHITE);
    setUndecorated(false);
    background.add(prognosebutton);
    ergebnis.setBounds(152, 512, 145, 25);
    ergebnis.setText("");
    ergebnis.setEditable(false);
    background.add(ergebnis);
    // Ende Komponenten

    setVisible(true);
    setLayout(new BorderLayout());
    setSize(455,580);
    setVisible(true);




  } // end of public prognose

  // Anfang Methoden

  public static void main(String[] args) {
    new prognose(); 
  } // end of main

  public void prognosebutton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    String a;
    String b;
    a = spendenbetrag.getText();
    b = streamzeit.getText();
    double d;
    double e = Double.parseDouble(a);
    double f = Double.parseDouble(b);
    d = e*(60/f)*48;
    d = ((double)((int)(d*100)))/100;
    String g = String.valueOf(d);
    ergebnis.setText(g);
  } // end of prognosebutton_ActionPerformed

  // Ende Methoden
} // end of class prognose