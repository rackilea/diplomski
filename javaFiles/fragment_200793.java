Toolbar t = new Toolbar();
myForm.setToolbar(t);
t.setTitle("My title");
Command back = new Command("back") {

   @Override
   public void actionPerformed(ActionEvent evt) {
       myForm.showBack();
   }
};
myForm.setBackCommand(back);
t.addCommandToLeftBar(back);