executor.execute(new Runnable() {
        @Override
        public void run() {
                function1();
                // now fix the progress bar
                SwingUtilities.invokeLater(new Runnable() {
                    progBar.setIndeterminate(false);
                    progBar.setVisible(false);
                });
        }});