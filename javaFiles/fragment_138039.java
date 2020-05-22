public class MenuScreen extends JPanel implements MouseListener {

    private static final long serialVersionUID = 1L;
//-------------VARIABLES---------------//
    //JButton start = new JButton(basketball);
    JLabel options = new JLabel("Options");
    JLabel startGame = new JLabel(" >> Start << ");
//    gameScreen gS = new gameScreen();
    BufferedImage wallpaper;

//-------------PAINT FUNCTION----------//
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("paint");
        super.paintComponent(g);
        if (wallpaper != null) {
            g.drawImage(wallpaper, 0, 0, this);
        }
    }

//-------------CONSTRUCTOR-------------//
    public MenuScreen() {

        // Please handle your exceptions better
        try {
            wallpaper = ImageIO.read(getClass().getResource("/Menu.png"));
            setPreferredSize(new Dimension(wallpaper.getWidth(), wallpaper.getHeight()));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        setLayout(new GridBagLayout());

        Cursor cusor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        options.setCursor(cusor);
        startGame.setCursor(cusor);

        Font font = UIManager.getFont("Label.font").deriveFont(Font.BOLD, 48);
        options.setFont(font);
        startGame.setFont(font);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        this.add(options, gbc);
        gbc.gridy++;
        this.add(startGame, gbc);
        startGame.addMouseListener(this);
        options.addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == (startGame)) {
            fireActionPerformed("startGame");
        }
        if (e.getSource() == (options)) {
            fireActionPerformed("gameOptions");
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    protected void fireActionPerformed(String cmd) {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners != null && listeners.length > 0) {
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, cmd);
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }
    }
}