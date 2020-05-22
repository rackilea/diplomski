class MyScreen extends MainScreen {
    private LabelField lblOne, lblTwo, lblThree;

    public MyScreen() {
        CustomVerticalFieldManger cvfm = new CustomVerticalFieldManger();
        cvfm.setBackground(BackgroundFactory.createSolidBackground(Color.AQUA));

        lblOne = new LabelField("The quick brown fox jumps over the lazy dog");
        lblTwo = new LabelField("The quick brown fox jumps over the lazy dog");
        lblThree = new LabelField("The quick brown fox jumps over the lazy dog");

        cvfm.add(lblOne);
        cvfm.add(lblTwo);
        cvfm.add(lblThree);

        add(cvfm);

        changeFont();
    }

    private int fontSize = 5;

    private void changeFont() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                UiApplication.getUiApplication().invokeLater(new Runnable() {
                    public void run() {
                        if (fontSize == 50) {
                            fontSize = 5;
                        }
                        lblOne.setFont(Font.getDefault().derive(Font.PLAIN,
                                fontSize));
                        lblTwo.setFont(Font.getDefault().derive(Font.PLAIN,
                                fontSize + 2));
                        lblThree.setFont(Font.getDefault().derive(Font.PLAIN,
                                fontSize + 4));
                        fontSize += 6;
                        updateLayout();
                        invalidate();
                    }
                });
            }
        };

        timer.schedule(task, 500, 1000);
    }
}