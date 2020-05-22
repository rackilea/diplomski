class CustomDialog extends JDialog
{
    private JFrame mainWindow;
    public CustomDialog(JFrame owner, String title, boolean modal)
    {
        super(owner, title, modal);
        mainWindow = owner;
        JPanel contentPane = new JPanel();
        JLabel dialogLabel = new JLabel(
                "I am a Label on JDialog.", JLabel.CENTER);
        contentPane.add(dialogLabel);
        setContentPane(contentPane);
        pack();

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //mainWindow.setLocationRelativeTo(null);
                //setLocationRelativeTo(null);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice[] gs = ge.getScreenDevices();
                for (int j = 0; j < gs.length; j++) {
                    GraphicsDevice gd = gs[j];
                    GraphicsConfiguration[] gc = gd.getConfigurations();
                    for (int i=0; i < gc.length; i++) {
                        Rectangle gcBounds = gc[i].getBounds();

                        Point loc = mainWindow.getLocationOnScreen();
                        if (gcBounds.contains(loc)) {
                            System.out.println("at " + j + " screen");

                            int x = gcBounds.x + (gcBounds.width - mainWindow.getWidth()) / 2;
                            int y = gcBounds.y + (gcBounds.height - mainWindow.getHeight()) / 2;
                            mainWindow.setLocation(x, y);

                            //x = (int) (loc.getX() + (mainWindow.getWidth() - CustomDialog.this.getWidth()) / 2);
                            //y = (int) (loc.getY() + (mainWindow.getHeight() - CustomDialog.this.getHeight()) / 2);
                            //CustomDialog.this.setLocation(x, y);
                            CustomDialog.this.setLocationRelativeTo(mainWindow);

                            break;
                        }
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                /*
                 * Nothing written for this part yet
                 */
            }
        });
    }
}