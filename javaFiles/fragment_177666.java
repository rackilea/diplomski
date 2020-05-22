@Override
public void actionPerformed(ActionEvent e) {
    JFileChooser selectElement = new JFileChooser();
    String path;

    // get the path String and set it
    int status = selectElement.showOpenDialog(null);

    if (status == JFileChooser.APPROVE_OPTION) {
        path = selectElement.getSelectedFile().getAbsolutePath();
    } else {
        path = null;
    }

    // pass the path String into the Gui by calling the call-back method, passing it in
    consumer.accept(path);
}