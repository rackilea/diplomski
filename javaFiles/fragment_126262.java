if (event.getSource() == destinationButton) {
            returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedDestinationFile = fc.getSelectedFile();
                destinationText.setText(selectedDestinationFile.getName());
            }
        }