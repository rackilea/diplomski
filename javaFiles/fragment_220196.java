//
  // Step 3: Makeing this work
  //
  public class Volume extends JWindow {
    private JPanel panelFirst;
    private JProgressBar a;
    public Volume() {
      try {
                  // Set cross-platform Java L&F (also called "Metal")
              UIManager.setLookAndFeel(
                  UIManager.getCrossPlatformLookAndFeelClassName());
          } 
          catch (UnsupportedLookAndFeelException e) {
            // handle exception
          }
          catch (ClassNotFoundException e) {
            // handle exception
          }
          catch (InstantiationException e) {
            // handle exception
          }
          catch (IllegalAccessException e) {
            // handle exception
          }      
      setLayout(new BorderLayout());
      setBounds(40, 40, 350, 60);
      panelFirst = new JPanel();        
      panelFirst.setBackground(Color.BLACK);    
      panelFirst.setLayout(new FlowLayout(FlowLayout.LEFT, 8,5));        
      a = createJP(100); 
      panelFirst.add(a);
      add(panelFirst);
      setVisible(true);
      setAlwaysOnTop(true);
    }

    public JProgressBar createJP(int input) {
      JProgressBar jp = new JProgressBar(JProgressBar.VERTICAL, 0, 100);
      jp.setPreferredSize(new Dimension(15, 50));
      jp.setValue(input);
      jp.setBackground(Color.BLACK);
      jp.setVisible(true);
      return jp;  
    }
    public void up(int input) {
      a.setForeground(Color.GREEN);
    }
  }