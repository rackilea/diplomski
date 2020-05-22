public void print(String texto) {
    // String anterior = txp_Console.getText();
    // txp_Console.setText(anterior + texto);
    if (SwingUtilities.isEventDispatchThread()) {
        // if on the Swing event thread, call directly
        txp_Console.append(texto);  // a simple append call is all that is needed
    } else {
        // else queue it onto the event thread
        SwingUtilities.invokeLater(() -> txp_Console.append(texto));
    }
}