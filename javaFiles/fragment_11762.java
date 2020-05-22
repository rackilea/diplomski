private void setButtonAction(){
    reverseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String txt = new StringBuilder(input.getText()).reverse().toString();
            output.append(txt);
        }
    });
}