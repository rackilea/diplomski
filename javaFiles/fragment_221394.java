JWindow window = new JWindow();

        demoform1 df = new demoform1();

        window.getContentPane().add(df.getContentPane());

        window.setBounds(600,600,600,600);
        window.setLocationRelativeTo(null);

        window.setVisible(true);
        try {
             for (int i = 0; i <= 100; i++) {
                    Thread.sleep(40);
                    df.loading.setText(Integer.toString(i) + "%");
                    df.loadingnum.setValue(i);
                    if (i == 100) {
                        window.setVisible(false);
                        JFrame frame = new JFrame();
                        frame.add(new JLabel("It Worked!!!!!"));
                        frame.setVisible(true);
                        frame.setSize(300,100);
                        window.dispose();
                    }
                }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }