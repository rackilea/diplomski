btn.addActionListener(new ActionListener() { 
  public void actionPerformed(ActionEvent e) { 
    txtArea.setText(null); //clear out old text
    for(String str: ll1) {
      txtArea.append(str+"\n");
    }
    panel.revalidate(); //repaint JPanel
  } 
});