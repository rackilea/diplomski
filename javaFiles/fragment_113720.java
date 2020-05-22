public void processButtonPress(ActionEvent event) {
        if (event.getSource() == write) {
            try {
                // On button press write to file
                fw.write("Testing file writing");
                // Close filewriter
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();

                // Code to handle goes here...
            }
        }
    }