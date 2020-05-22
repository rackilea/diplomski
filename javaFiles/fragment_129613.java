package com.test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class typeTutor extends JFrame implements KeyListener {

    Map<Integer, JButton> map = new HashMap<Integer, JButton>();

    // Individual keyboard rows
    String firstRow[] = { "~", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "+", "fill",
            "BackSpace" };
    String secondRow[] = { "Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "[", "]", "\\" };
    String thirdRow[] = { "Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "fill",
            "fill", "Enter" };
    String fourthRow[] = { "Shift", "Z", "X", "C", "V", "B", "N", "M", ",", ".", "?", "blank", "^" };
    String fifthRow[] = { "blank", "blank", "fill", "fill", "fill", "fill", "fill", "fill", "fill",
            "fill", "", "<", "v", ">" };
    private JTextField textField;
    // Individual keyboard rows
    /*
     * String firstRow[] = {"~","1","2","3","4","5","6","7","8","9","0","-","+","BackSpace"}; String
     * secondRow[] = {"Tab","Q","W","E","R","T","Y","U","I","O","P","[","]","\\"}; String thirdRow[]
     * = {"Caps","A","S","D","F","G","H","J","K","L",":","\"","Enter"}; String fourthRow[] =
     * {"Shift","Z","X","C","V","B","N","M",",",".","?","   ^" }; String
     * fifthRow[]={"               " ,"<" ,"v",">" };
     */
    String strText = "";
    // all keys without shift key press
    String noShift = "`1234567890-=qwertyuiop[]\\asdfghjkl;'zxcvbnm,./";
    // special characters on keyboard that has to be addressed during key press
    String specialChars = "~-+[]\\;',.?";
    int keycode;

    JTextArea text = new JTextArea();

    // Jbuttons corresponding to each individual rows
    JButton first[];
    JButton second[];
    JButton third[];
    JButton fourth[];
    JButton fifth[];

    // default color of the button to be repainted when key released
    Color cc = new JButton().getBackground();

    // Driver main method to start the application
    public static void main(String[] args) {
        // launch typing tutor
        typeTutor a = new typeTutor();
        a.setVisible(true);
    }

    // No argument constructor to create frame
    public typeTutor() {
        super("Type Tutor - My JAC444");

        JPanel contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                Graphics2D g2d = (Graphics2D) grphcs;
                Dimension d = this.getSize();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

                GradientPaint gp = new GradientPaint(0, 0, getBackground().brighter().brighter(),
                        0, d.height, getBackground().darker().darker());

                g2d.setPaint(gp);
                g2d.fillRect(0, 0, d.width, d.height);

                super.paintComponent(grphcs);
            }
        };
        contentPane.setOpaque(false);
        setContentPane(contentPane);

        // textField = new JTextField(80);
        // text.setEditable(true);

        TextFieldHandler handler = new TextFieldHandler();

        // set the info label on top
        JLabel info = new JLabel(
                "<html>&nbsp;&nbsp;Type some text using your keyboard.The keys you press will be highlighted and text will be displayed.<br> &nbsp;&nbsp;Note : Clicking the buttons with your mouse will not perform any action. <br><br> </html>");
        // set the bold font for info
        info.setFont(new Font("Verdana", Font.BOLD, 12));

        // set the layout and place component in place and pack it
        setLayout(new BorderLayout());

        // Various panel for the layout
        JPanel jpNorth = new JPanel();
        JPanel jpCenter = new JPanel();
        jpCenter.setPreferredSize(new Dimension(10, 10));
        JPanel jpKeyboard = new JPanel(new GridBagLayout());
        JPanel jpNote = new JPanel();

        add(jpNorth, BorderLayout.NORTH);
        add(jpNote);

        add(jpCenter, BorderLayout.CENTER);
        add(jpKeyboard, BorderLayout.SOUTH);

        jpNorth.setLayout(new BorderLayout());
        jpNorth.add(info, BorderLayout.WEST);
        jpNorth.add(info, BorderLayout.SOUTH);

        jpCenter.setLayout(new BorderLayout());
        jpCenter.add(text, BorderLayout.WEST);

        jpCenter.add(text, BorderLayout.CENTER);
        jpCenter.setPreferredSize(new Dimension(10, 10));

        first = new JButton[firstRow.length];
        second = new JButton[secondRow.length];
        third = new JButton[thirdRow.length];
        fourth = new JButton[fourthRow.length];
        fifth = new JButton[fifthRow.length];

        addKeys(jpKeyboard, 0, firstRow, first);
        addKeys(jpKeyboard, 1, secondRow, second);
        addKeys(jpKeyboard, 2, thirdRow, third);
        addKeys(jpKeyboard, 3, fourthRow, fourth);
        addKeys(jpKeyboard, 4, fifthRow, fifth);

        // jpCenter.setPreferredSize(new Dimension(10,10));
        jpKeyboard.setPreferredSize(new Dimension(800, 160));

        info.setOpaque(false);
        jpNote.setOpaque(false);
        jpNorth.setOpaque(false);
        jpCenter.setOpaque(false);
        jpKeyboard.setOpaque(false);

        // add listeners
        // getComponent().addKeyListener(this);
        text.addKeyListener(this);
        // add listeners to all the button
        /*
         * for (JButton b : first) { if (b != null) { b.addKeyListener(this); } }
         */
        /*
         * for(JButton b : second) b.addKeyListener(this); for(JButton b : third)
         * b.addKeyListener(this);
         * 
         * for(JButton b : fourth) b.addKeyListener(this);
         * 
         * for(JButton b : fifth) b.addKeyListener(this);
         */

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set non re-sizable
        this.setResizable(false);
        // set size of the content pane ie frame
        this.getContentPane().setPreferredSize(new Dimension(1100, 350));
        // set location for the frame
        // this.setLocation(150,150);
        // init and paint frame
        initWidgets();
        pack();
        this.toFront(); // brings this Window to the front and may make it the focused Window
        this.setLocationRelativeTo(null); // Window appears center

    }

    // Method to initialize frame component
    private void initWidgets() {

    }

    private class TextAreaHandler implements ActionListener {
        // process textfield events
        public void actionPerformed(ActionEvent event) {
            String string = ""; // declare string to display

            // user pressed Enter in JTextField textField1
            if (event.getSource() == textField)
                string = String.format("%s", event.getActionCommand());
        }
    }

    // Invoked when a key has been pressed.
    // @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
    public void keyPressed(KeyEvent evt) {
        keycode = evt.getKeyCode();
        strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

        JButton btn = map.get(keycode);
        if (btn != null) {
             map.get(keycode).setBackground(Color.BLUE);
        }

    }// end of key pressed

    // Invoked when a key has been released.
    public void keyReleased(KeyEvent evt) {
        keycode = evt.getKeyCode();
        strText = String.format("%s", KeyEvent.getKeyText(evt.getKeyCode()));

        JButton btn = map.get(keycode);
        if (btn != null) {
             map.get(keycode).setBackground(Color.WHITE);
        }
    }

    public void keyTyped(KeyEvent evt) {
        strText = String.format("%s", evt.getKeyChar());
    }// end of key pressed

    private class TextFieldHandler implements ActionListener {
        // process textfield events
        public void actionPerformed(ActionEvent event) {
            String string = ""; // declare string to display

            // user pressed Enter in JTextField textField1
            if (event.getSource() == text)
                strText = String.format("%s", event.getActionCommand());
        }
    }

    protected void addKeys(JPanel parent, int row, String[] keys, JButton[] buttons) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = row;
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.BOTH;

        int gap = 0;
        for (int index = 0; index < keys.length; index++) {
            String key = keys[index];
            if ("blank".equalsIgnoreCase(key)) {
                gbc.gridx++;
            } else if ("fill".equalsIgnoreCase(key)) {
                gbc.gridwidth++;
                gap++;
            } else {
                // System.out.println("Add " + key);
                JButton btn = new JButton(key);
                buttons[index] = btn;
                parent.add(btn, gbc);
                gbc.gridx += gap + 1;
                gbc.gridwidth = 1;
                gap = 0;

                System.out.println(key);
                btn.setBackground(Color.WHITE);
                map.put(getKeyCode(key), btn);
            }
        }

    }

    private int getKeyCode(String key) {
        if (key.equals("BackSpace")) {
            return KeyEvent.VK_BACK_SPACE;
        } else if (key.equals("Tab")) {
            return KeyEvent.VK_TAB;
        } else if (key.equals("Caps")) {
            return KeyEvent.VK_CAPS_LOCK;
        } else if (key.equals("Enter")) {
            return KeyEvent.VK_ENTER;
        } else if (key.equals("Shift")) {
            return KeyEvent.VK_SHIFT;
        } else if (key.equals("")) {
            return KeyEvent.VK_SPACE;
        } else if (key.equals("+")) {
            return KeyEvent.VK_EQUALS;
        }else if (key.equals(":")) {
            return KeyEvent.VK_SEMICOLON;
        }else if (key.equals("\"")) {
            return KeyEvent.VK_QUOTE;
        }else if (key.equals("?")) {
            return KeyEvent.VK_SLASH;
        }else if (key.equals("~")) {
            return KeyEvent.VK_BACK_QUOTE;
        } else if (key.equals("^")) {
            return KeyEvent.VK_UP;
        } else if (key.equals("v")) {
            return KeyEvent.VK_DOWN;
        } else if (key.equals("<")) {
            return KeyEvent.VK_LEFT;
        } else if (key.equals(">")) {
            return KeyEvent.VK_RIGHT;
        } else {
            return (int) key.charAt(0);
        }
    }

}// end of class