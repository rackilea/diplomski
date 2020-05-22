button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int result = chooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            String type = comboBox.getSelectedItem().toString();
            File file = chooser.getSelectedFile();
            if ("binary".equals(type)) {
                // do binary action
            } else {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    textArea.read(reader, null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
});