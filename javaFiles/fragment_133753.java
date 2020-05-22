next.addActionListener(new ActionListener(){
 public void actionPerformed(ActionEvent e){
    if(countertwo == 0){
        job1.setVisible(true);
        countertwo++;
    }
    if(countertwo == 1){
        job1.setText("Ready");
        countertwo++;
    }
    if(countertwo == 2){
        job2.setVisible(true);
        job1.setVisible(false);
    }
}
});