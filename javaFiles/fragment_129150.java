public void setImagem(BufferedImage imagem) {
    this.imagem = imagem;
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if (imagem != null) {
        g.drawImage(imagem, 0, 0, this);
    }
}

@Override
public Dimension getPreferredSize() {
    Dimension sz = super.getPreferredSize();
    if (imagem != null) {
        sz = new Dimension(imagem.getWidth(), imagem.getHeight());
    }
    return sz;
}

private static void createAndShowGui() {
    MyOpenSave openSave = new MyOpenSave();

    JFrame frame = new JFrame("MyOpenSave");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(openSave);
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGui());
}