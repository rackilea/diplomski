@SuppressWarnings("serial")
public class OpenSave extends JPanel {
    private BufferedImage imagem;

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
}