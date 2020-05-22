Timer timercasovac = new Timer(1250, new ActionListener() {
    private int counter;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Say hello");
        counter++;
        if (counter == 4) {
            ((Timer)e.getSource()).stop();
        }
    }
});
timercasovac.start();