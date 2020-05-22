class DialogYouWantToOpen extends JDialog{
       JLabel testLabel = new JLable();
       public DialogYouWantToOpen(int row, int column){
         setSize(200,200)
         setLayout(new FlowLayout());
         testLabel.setText("User double clicked at row "+row+" and column "+ column);
         add(testLabel);
       }

}