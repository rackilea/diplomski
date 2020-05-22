} else if (e.getSource() == openitem) {
    int answer = fc.showOpenDialog(null); // (JFrame.this) when in JFrame
    if (answer == JFileChooser.APPROVE_OPTION) {
        File file = fc.getSelectedFile();
        byte[] content = Files.readAllBytes(file.toPath());
        String text = new String(content); // Using default encoding
        jLabel1.setText(text);
    }