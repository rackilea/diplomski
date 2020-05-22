fr.addWindowListener(new WindowAdapter() {

            // Implements all abstract method.

            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    save.saveAll();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
    });