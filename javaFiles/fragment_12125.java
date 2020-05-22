void onButtonPressed() {
    // The code to open the file dialog goes here

    button.setText("");
    ImageIcon progressbar = new     
        ImageIcon(DatasetExporterUI.class.getResource("/progreassbar.gif"));
        buttonExport.setIcon(progressbar);

    new Thread() {
        @Override
        public void run() {
            // do some database operations here

            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    //again remove icon from button
                    button.setIcon(null);
                    button.setText("click");
                }
            });
        }
    }.start();
}