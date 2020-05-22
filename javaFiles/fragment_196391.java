final JSlider horse1 = new JSlider(0, 100, 0);
final JSlider horse2 = new JSlider(0, 100, 0);
final JSlider horse3 = new JSlider(0, 100, 0);

Timer timer = new Timer(100, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Random random = new Random();

        int horse1Value = horse1.getValue();
        horse1Value += random.nextInt(101 - horse1Value);
        horse1.setValue(horse1Value);

        int horse2Value = horse2.getValue();
        horse2Value += random.nextInt(101 - horse2Value);
        horse2.setValue(horse2Value);

        int horse3Value = horse3.getValue();
        horse3Value += random.nextInt(101 - horse3Value);
        horse3.setValue(horse3Value);

        if(horse1Value == 100 && horse2Value == 100 && horse3Value == 100) {
            System.out.println("Race finished!");
            Timer timer = (Timer)e.getSource();
            timer.stop();
        }
    }
});
timer.setRepeats(true);
timer.start();