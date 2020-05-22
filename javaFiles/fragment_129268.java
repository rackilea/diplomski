tabbedPane = new JTabbedPane(JTabbedPane.TOP);

    tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI(){


        protected void paintContentBorder(Graphics g,int tabPlacement,int selectedIndex){} //removes tab content border.
        protected void paintTabBorder(Graphics g, int tabPlacement,int tabIndex,int x, int y, int w, int h,boolean isSelected){} //removes tab (title) border.
    });
    tabbedPane.setForeground(Color.DARK_GRAY);
    tabbedPane.setBounds(new Rectangle(0, 0, 0, 333));
    tabbedPane.setBorder(new EmptyBorder(0, 0, 0, 0));
    tabbedPane.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 12));
    tabbedPane.setBackground(new Color(0,0,0,0));
    //tabbedPane.setOpaque(false); not needed
    tabbedPane.setBounds(5, 95, 789, 333);