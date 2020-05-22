import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Lattice extends JPanel implements ActionListener {

protected Font  axisFont, rectFont, carrFont;

protected Color boxColor = new Color (25, 143, 103),    gridColor = new Color (78, 23, 211),
        diagColor = new Color (93, 192, 85),    fontColor = new Color (23, 187, 98),
        carrColor = new Color (162, 34, 19);

protected int   nDigitP, nDigitQ, dSize = 60,
        m1, m2, lastCarry, iResult[],
        xDigits[], yDigits[], prodTL[][], prodBR[][];

public Lattice (int p, int q, Font font) {
    nDigitP = (int) Math.ceil (Math.log10 (p)); xDigits = new int[nDigitP];
    nDigitQ = (int) Math.ceil (Math.log10 (q)); yDigits = new int[nDigitQ];

    prodTL = new int[nDigitP][nDigitQ];     prodBR = new int[nDigitP][nDigitQ];

    m1 = p; m2 = q;                 // To display in report
    int np = p, nq = q, size = font.getSize();  // Save the digits in array

    for (int i = 0 ; i < nDigitP ; i++) {
        xDigits[i] = np % 10;
        np /= 10;
    }
    for (int i = 0 ; i < nDigitQ ; i++) {
        yDigits[i] = nq % 10;
        nq /= 10;
    }

    for (int i = 0 ; i < nDigitP ; i++) {       // Cell products as upper/lower matrix
        for (int j = 0 ; j < nDigitQ ; j++) {
            int prod = xDigits[i] * yDigits[j];
            prodTL[i][j] = prod / 10;
            prodBR[i][j] = prod % 10;
    }}

    axisFont = font.deriveFont (Font.PLAIN, size+8.0f);
    rectFont = font.deriveFont (Font.PLAIN, size+4.0f);
    carrFont = font.deriveFont (Font.PLAIN);

    setPreferredSize (new Dimension ((nDigitP+2)*dSize, (nDigitQ+2)*dSize));
}

public void paint (Graphics g) {
    int w = getWidth(), h = getHeight();
    Graphics2D g2 = (Graphics2D) g;         // To make diagonal lines smooth
    g2.setPaint (Color.white);
    g2.fillRect (0,0,w,h);

    int dx = (int) Math.round (w/(2.0+nDigitP)),    // Grid spacing to position
        dy = (int) Math.round (h/(2.0+nDigitQ));    // the lines and the digits

    g2.setRenderingHint (RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
    g2.setRenderingHint (RenderingHints.KEY_INTERPOLATION,
                                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

    g2.setFont (axisFont);
    FontMetrics fm = g2.getFontMetrics();
    for (int i = 0 ; i < nDigitP ; i++) {       // Grid || Y-axis and labels on axis
        int px = w - (i+1)*dx;
        g2.setPaint (gridColor);
        if (i > 0)
            g2.drawLine (px, dy, px, h-dy);
        String str = /*i + */"" + xDigits[i];
        int strw = fm.stringWidth (str);
        g2.setPaint (fontColor);
        g2.drawString (str, px-dx/2-strw/2, 4*dy/5);
    }

    for (int i = 0 ; i < nDigitQ ; i++) {       // Grid || X-axis and labels on axis
        int py = h - (i+1)*dy;
        g2.setPaint (gridColor);
        if (i > 0)
            g2.drawLine (dx, py, w-dx, py);
        String str = /*i + */"" + yDigits[i];
        int strw = fm.stringWidth (str);
        g2.setPaint (fontColor);
        g2.drawString (str, w-dx+2*dx/5-strw/2, py-dy/2+10);
    }

    g2.setFont (rectFont);
    fm = g2.getFontMetrics();           // Upper/Lower traingular product matrix
    for (int i = 0 ; i < nDigitP ; i++) {
        for (int j = 0 ; j < nDigitQ ; j++) {
            int px = w - (i+1)*dx;
            int py = h - (j+1)*dy;

            String strT = "" + prodTL[i][j];
            int strw = fm.stringWidth (strT);
            g2.drawString (strT, px-3*dx/4-strw/2, py-3*dy/4+5);

            String strB = "" + prodBR[i][j];
            strw = fm.stringWidth (strB);
            g2.drawString (strB, px-dx/4-strw/2, py-dy/4+5);
    }}

    g2.setFont (axisFont);
    fm = g2.getFontMetrics();
    int carry = 0;
    Vector cVector = new Vector(), iVector = new Vector();
    for (int k = 0 ; k < 2*Math.max (nDigitP, nDigitQ) ; k++) {
        int dSum = carry, i = k/2, j = k/2;
        //System.out.println ("k="+k);
        if ((k % 2) == 0) {             // even k
            if (k/2 < nDigitP && k/2 < nDigitQ)
                dSum += prodBR[k/2][k/2];
            // go right and top
            for (int c = 0 ; c < k ; c++) {
                if (--i < 0)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodTL[i][j];
                    //System.out.println (" >> TL (i,j) = (" + i+","+j+")");
                if (++j == nDigitQ)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodBR[i][j];
                    //System.out.println (" >> BR (i,j) = (" + i+","+j+")");
            }
            // go bottom and left
            i =  k/2; j = k/2;
            for (int c = 0 ; c < k ; c++) {
                if (--j < 0)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodTL[i][j];
                    //System.out.println (" >> TL (i,j) = (" + i+","+j+")");
                if (++i == nDigitP)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodBR[i][j];
                    //System.out.println (" >> BR (i,j) = (" + i+","+j+")");
        }} else {                   // odd k
            if (k/2 < nDigitP && k/2 < nDigitQ)
                dSum += prodTL[k/2][k/2];
            // go top and right
            for (int c = 0 ; c < k ; c++) {
                if (++j == nDigitQ)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodBR[i][j];
                    //System.out.println (" >> BR (i,j) = (" + i+","+j+")");
                if (--i < 0)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodTL[i][j];
                    //System.out.println (" >> TL (i,j) = (" + i+","+j+")");
            }
            i =  k/2; j = k/2;
            // go left and bottom
            for (int c = 0 ; c < k ; c++) {
                if (++i == nDigitP)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodBR[i][j];
                    //System.out.println (" >> BR (i,j) = (" + i+","+j+")");
                if (--j < 0)
                    break;
                if (i < nDigitP && j < nDigitQ)
                    dSum += prodTL[i][j];
                    //System.out.println (" >> TL (i,j) = (" + i+","+j+")");
        }}

        int digit = dSum % 10;  carry = dSum / 10;
        cVector.addElement (new Integer (carry));
        iVector.addElement (new Integer (digit));
        String strD = "" + digit;
        int strw = fm.stringWidth (strD);
        if (k < nDigitP) {
            int px = w - (k+1)*dx - 4*dx/5, py = h-dy + fm.getHeight();
            g2.drawString (strD, px-strw/2, py);
        } else {
            int px = dx - 12, py = h - (k-nDigitP+1)*dy - dy/4;
            g2.drawString (strD, px-strw/2, py+5);
    }} // End k-loop

    g2.setPaint (diagColor);
    for (int i = 0 ; i < nDigitP ; i++) {
        int xt = (i+1) * dx,
            yb = (i+2) * dy;
        g2.drawLine (xt, dy, 0, yb);
    }
    for (int i = 0 ; i < nDigitQ ; i++) {
        int xb = (i + nDigitP - nDigitQ) * dx,
            yr = (i+1) * dy;
        g2.drawLine (w-dx, yr, xb, h);
    }

    // System.out.println ("carry Vector has " + cVector.size() + " elements");
    g2.setFont (carrFont);
    g2.setPaint (carrColor);
    fm = g2.getFontMetrics();
    for (int k = 0 ; k < 2*Math.max (nDigitP, nDigitQ) ; k++) {
        carry = ((Integer) cVector.elementAt (k)).intValue();
        lastCarry = carry;  // To display
        if (carry == 0)
            continue;
        String strC = "" + carry;
        int strw = fm.stringWidth (strC),
            px = w-dx-5-strw/2,         // Const X while going Up
            py = dy + fm.getHeight();       // Const Y while going Left
        if (k < (nDigitQ-1))
            py = h-(k+3)*dy + dy/5 + fm.getHeight();
        else
            px = w - (k-nDigitQ+2) * dx - dx/2 - strw/2;
        g2.drawString (strC, px, py);
    }

    int n = iVector.size();     // Save the vector content to display later
    iResult = new int[n];
    for (int i = 0 ; i < n ; i++)
        iResult[i] = ((Integer) iVector.elementAt (n-i-1)).intValue();
    g2.setPaint (boxColor);     g2.drawRect (dx, dy, w-2*dx, h-2*dy);
}

private void displayResults () {
    StringBuffer sb = new StringBuffer ("Lattice: " + m1 + " \u00D7 " + m2 + " = " + 
                        ((lastCarry == 0) ? "" : (""+lastCarry)));
    for (int k = 0 ; k < iResult.length ; k++)
        sb.append ("" + iResult[k]);
    // System.out.println (sb.toString());
    JOptionPane.showMessageDialog (null, sb.toString(), "Lattice Multiplier",
                            JOptionPane.INFORMATION_MESSAGE);
}

public JPanel getButtonPanel () {
    JPanel bp = new JPanel(new GridLayout (1,bNames.length));
    for (int i = 0 ; i < bNames.length ; i++) {
        JButton b = new JButton (bNames[i]);
        b.addActionListener (this);
        bp.add (b);
    }
    return bp;
}

private final static String[] bNames = {"Close", "Result"};

public void actionPerformed (ActionEvent e) {
    String cmd = e.getActionCommand();
    if (cmd.equals (bNames[0]))     System.exit (0);
    else if (cmd.equals (bNames[1]))    displayResults();
}

public static void main (String[] args) {
    JTextField tf1 = new JTextField (), tf2 = new JTextField();
    JPanel num2m = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets (2,2,2,2);

    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = GridBagConstraints.RELATIVE;
    gbc.anchor = GridBagConstraints.EAST;

    JLabel
    label = new JLabel ("Multiplicand", JLabel.TRAILING);   num2m.add (label, gbc);
    label = new JLabel ("Multiplier", JLabel.TRAILING); num2m.add (label, gbc);
    gbc.gridx++;
    gbc.weightx = 1.0f;     num2m.add (tf1, gbc);   num2m.add (tf2, gbc);

    JFrame lf = new JFrame ("Lattice Multiplication");
    if (JOptionPane.showConfirmDialog (lf, num2m, "Enter numbers to multiply",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE ) == JOptionPane.OK_OPTION) {
        try {
            int m = Integer.parseInt (tf1.getText()), n = Integer.parseInt (tf2.getText());
            Lattice lattice = new Lattice (m, n, label.getFont());
            lf.add (lattice.getButtonPanel(), "South");
            lf.add (lattice, "Center");
            lf.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
            lf.pack();
            lf.setVisible (true);
        } catch (NumberFormatException nex) {
            JOptionPane.showMessageDialog (lf, "Invalid numbers to multiply",
                    "Lattice Multiplier Error", JOptionPane.ERROR_MESSAGE);
            System.exit (1);
    }} else {   System.exit (2);
}}}