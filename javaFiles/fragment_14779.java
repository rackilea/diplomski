public class J2MeImageLayer extends ScalableLayer {
    private static final long serialVersionUID = -4606125807092612043L;

    public J2MeImageLayer() {
        componentViewer.super();
    }
    @Override
    public void repaint() {
        J2SEMutableImage mutableImage = new J2SEMutableImage(page.getSize().width, page.getSize().height);
        page.paint(mutableImage.getGraphics());
        Graphics g = getImage().getGraphics();
        g.drawImage(mutableImage.getImage(), 0, 0, DCP_Simulator.this);
    }
    public void addComponent(Component component) {
        page.add(component);
    }
    public void setComponent(final Component component) {
        page.removeAllElements();
        final Container componentParent;
        if ((componentParent = component.getParent()) != null)
            component.setRemovedAction(new interfaces.Action() {
                @Override
                public void action() {
                    componentParent.add(component);
                }
            });
        page.add(component);
    }
}