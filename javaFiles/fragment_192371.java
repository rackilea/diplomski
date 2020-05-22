ouFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // close/stop audio stream here
                System.out.println("closed");
            }
    });