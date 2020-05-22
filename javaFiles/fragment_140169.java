public static void addActionListener(JMenuItem menuItem, Callback callback) //Need parsed Method   {
   menuItem.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            callback.doAction();
        }
    });
}