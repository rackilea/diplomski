public void runProcess() {

    view.addButtonListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            business.runProcess();
        }}
    );
}