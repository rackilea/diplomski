class ValidarPrecio extends KeyAdapter {
    public void keyTyped(java.awt.event.KeyEvent evento) {
        char c = evento.getKeyChar();
        if (c < '0' || c > '9') {
            evento.consume();
        }
    }
}