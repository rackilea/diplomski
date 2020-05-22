public void actionPerformed(ActionEvent event) {
    textArea.setText("");

    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            String result = // call a REST API
            textArea.setText(result);
        }
    });
}