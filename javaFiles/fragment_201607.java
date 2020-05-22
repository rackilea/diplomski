private static class PlaySoundActionListener implements ActionListener {

    private String soundPath;

    private PlaySoundActionListener(String soundPath) {
        this.soundPath = soundPath;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // play the sound at this.soundPath
    }
}

...

button1.addActionListener(new PlaySoundActionListener("resources/buttonOne.wav"));
button2.addActionListener(new PlaySoundActionListener("resources/buttonTwo.wav"));
button3.addActionListener(new PlaySoundActionListener("resources/buttonThree.wav"));