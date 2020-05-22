Timer t = new Timer(1000, new ActionListener() {
    private int ans = functions.secC();
    public void actionPerformed(ActionEvent e) {
        label.setText("Server will shutdown in: "+ans+ "seconds");
        ans--;
    }
});