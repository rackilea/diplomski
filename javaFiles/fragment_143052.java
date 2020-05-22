//Create UI and set L&F on EDT
    SwingUtilities.invokeLater(new Runnable( ) {
        public void run( ) {
                //set L&F
                try {
                       for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                           if ("Nimbus".equals(info.getName())) {
                                   UIManager.setLookAndFeel(info.getClassName());
                                   break;
                           }
                       }
                    } catch (Exception e) {
                    // If Nimbus is not available, you can set the GUI to another look and feel.
                     e.printStackTrace();
                    }
            //create UI and components here
        }

    });