private class CalcListener implements ActionListener {
    private int x;
    private CalcListener(int x){
        this.x = x;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        calc.calculate(x);
    }
}