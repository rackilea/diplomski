public class ResizableImageView extends JDialog {
    BufferedImage img;
    Dimension OriginalImgSize;
    double imageRatio;
    JPanel jp;
    JLabel label;
    Dimension previousSize;

    public ResizableImageView(BufferedImage img) {

        ...

        setResizable(true);
        this.img = img;
        OriginalImgSize = new Dimension(img.getWidth(), img.getHeight());
        imageRatio = (double)img.getWidth() / (double)img.getHeight();

        label = new JLabel(new ImageIcon(img));
        label.setMinimumSize(OriginalImgSize);
        jp = new JPanel();
        jp.setBorder(new EmptyBorder(0, 0, 0, 0));
        jp.add(label);
        setContentPane(jp);
        pack();
        previousSize = getSize();

        addComponentListener(new ComponentAdapter() {
            private boolean allreadyResized = true;

            private void resize(Image img) {
                ImageIcon ico = new ImageIcon(img);
                label = new JLabel(ico);
                label.setBorder(new EmptyBorder(0, 0, 0, 0));
                label.setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
                jp = new JPanel();
                jp.setBorder(new EmptyBorder(0, 0, 0, 0));
                jp.add(label);
                setContentPane(jp);
                allreadyResized = true;
                pack();
                previousSize = getSize();
            }

            @Override
            public void componentResized(ComponentEvent e) {
                if (allreadyResized) {
                    allreadyResized  = false;
                    return;
                }
                double xChange = (double) Math.abs(getSize().width - previousSize.width);
                double yChange = (double) Math.abs(getSize().height - previousSize.height);
                if (xChange == 0 && yChange == 0) return; 
                int height = getSize().height - getInsets().bottom - getInsets().top;
                int width = getSize().width - getInsets().left - getInsets().right;

                if (height > OriginalImgSize.height 
                        || width > OriginalImgSize.width) {
                    resize(img);
                    return;
                }
                if (yChange == 0 || xChange/yChange > imageRatio) {
                    resize(img.getScaledInstance(width, -1, Image.SCALE_SMOOTH));
                    return;
                } else {
                    resize(img.getScaledInstance(-1, height, Image.SCALE_SMOOTH));
                    return;
                }
            }
        });
    }
}