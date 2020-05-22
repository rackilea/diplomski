EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoadingTry window = new LoadingTry();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });