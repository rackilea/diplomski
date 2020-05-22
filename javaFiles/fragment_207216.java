yesCB.addActionListener(new ActionListener() {

   @Override
   public void actionPerformed(ActionEvent e) {
      timeF.setEnabled(yesCB.isSelected());
      catF.setEnabled(yesCB.isSelected());
      yearsCB.setEnabled(yesCB.isSelected());
      monthsCB.setEnabled(yesCB.isSelected());
}});