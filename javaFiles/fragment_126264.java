if (event.getSource() == destinationButton) {
            returnVal = fc.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                selectedDestinationFile = fc.getSelectedFile();
                destinationText.setText(selectedDestinationFile.getName());

                //copy backup
                String name = selectedSourceFile.getName();
                name = selectedSourceFile.getName().substring(0, name.lastIndexOf(".")) + ".bak";
                File destinationFile = new File(selectedDestinationFile.getParentFile(), name);
                try {
                    Files.copy(selectedSourceFile.toPath(), destinationFile.toPath());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }