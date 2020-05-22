Command back = new Command("Back") {
     public void actionPerformed(ActionEvent ev) {
         // notice that when showing a previous form it is best to use showBack() so the 
         // transition runs in reverse
         showPreviousForm();
     }
};
f.setBackCommand(back);