Timer timer = new Timer(500, new ActionListener() {
    private int sequence = 0;
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(sequence + "; " + (sequence % 2));

        for (int index = 0; index < lights.length; index++) {

            if (index % 2 == 0 && sequence % 2 == 0 || index % 2 != 0 && sequence % 2 != 0) {
                lights[index].setBackground(Color.GREEN);
            } else {
                lights[index].setBackground(Color.BLACK);
            }

        }

        sequence++;
        if (sequence > 7) {
            sequence = 0;
        }
    }
});