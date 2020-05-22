if (match) {
    // Another class calculates
} else {
    outputField.setText("INPUT ERROR");
    ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            outputField.setText("");
        }
    };
    Timer timer = new Timer(5000, listener);
    timer.setRepeats(false);
    timer.start();
}