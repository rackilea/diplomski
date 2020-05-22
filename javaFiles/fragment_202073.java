public class JXLayerTest {

      public static void main(String[] args) {
           new JXLayerTest();
      }

      public JXLayerTest() {
           EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                     try {
                          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                     } catch (ClassNotFoundException ex) {
                     } catch (InstantiationException ex) {
                     } catch (IllegalAccessException ex) {
                     } catch (UnsupportedLookAndFeelException ex) {
                     }

                     final LockableUI ui = new LockableUI();
                     JPanel panel = new JPanel(new GridBagLayout());
                     buildUI(panel);

                     // This stolen directly from the JXLayer lockable blog                         
                     JXLayer layer = new JXLayer(panel, ui);

                     // Java2D grayScale BufferedImageOp
                     ColorConvertOp grayScale = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
                     // wrap it with the jxlayer's BufferedImageOpEffect 
                     BufferedImageOpEffect effect = new BufferedImageOpEffect(grayScale);
                     // set it as the locked effect        
                     ui.setLockedEffects(effect);
                     ui.setLocked(false);

                     JFrame frame = new JFrame();
                     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                     frame.setLayout(new BorderLayout());
                     frame.add(layer);

                     JPanel panelButtons = new JPanel(new GridBagLayout());

                     final JButton lock = new JButton("Lock");
                     lock.addActionListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                               boolean locked = !ui.isLocked();
                               ui.setLocked(locked);
                               lock.setText(locked ? "Unlock" : "Lock");

                          }
                     });

                     panelButtons.add(lock);
                     frame.add(panelButtons, BorderLayout.SOUTH);

                     frame.pack();
                     frame.setLocationRelativeTo(null);
                     frame.setVisible(true);
                }

                protected void buildUI(JPanel panel) {
                     GridBagConstraints gbc = new GridBagConstraints();
                     gbc.gridx = 0;
                     gbc.gridy = 0;

                     JLabel label = new JLabel();
                     try {
                          BufferedImage image = ImageIO.read(new File("megatokyo.png"));
                          label.setIcon(new ImageIcon(image));
                     } catch (IOException ex) {
                          label.setText("Nothing to see here");
                     }

                     panel.add(label, gbc);

                     JButton button = new JButton("Clickl me");
                     button.addActionListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent e) {
                               JOptionPane.showMessageDialog(null, "Clicked");
                          }
                     });

                     gbc.gridy++;
                     panel.add(button, gbc);

                }
           });
      }
 }