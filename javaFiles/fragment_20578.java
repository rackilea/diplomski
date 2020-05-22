for(int i = 0; i <= 9; i++) {
    final int finalCount = i;
    btns.get(i).addActionListener(new ActionListener(){ 
        public void actionPerformed(ActionEvent e){ 

            nums.setText(nums.getText() + finalCount);

        }       
    });
}