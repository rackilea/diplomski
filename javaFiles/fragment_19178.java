public void actionPerformed(ActionEvent e){
    JToggleButton btn = (JToggleButton)e.getSource();
    JToggleButton btn2 = (JToggleButton)e.getSource();

    firstClick(btn, btn2);
    secondClick(btn, btn2);
    matching(btn, btn2);
}