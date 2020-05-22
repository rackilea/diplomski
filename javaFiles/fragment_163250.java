class CenteredContentPanel extends JPanel { 
      CenteredContentPanel(JComponent addTo){
          this.setLayout(new GridLayout(1,1)); 
          JPanel parentPanel = new JPanel();
          parentPanel.add(addTo);
          this.add(parentPanel);
      }
 }