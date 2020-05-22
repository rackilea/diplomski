if (event.getSource() == chooseFileButton) {
            returnVal = fc.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedSourceFile = fc.getSelectedFile();
                sourceText.setText(selectedSourceFile.getName());
            }
        }