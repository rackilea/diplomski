public class ValidationUI extends HighlightComponentUI {

    public ValidationUI() {
        super(Color.RED);
    }

}

public class HighlightComponentUI extends AbstractLayerUI<JPanel> {

    private List<WeakReference<Component>> lstHighlights;
    private Color highlightColor;

    public HighlightComponentUI(Color highlight) {
        highlightColor = highlight;
        lstHighlights = new ArrayList<WeakReference<Component>>(25);
    }

    protected void cleanReferences() {
        if (lstHighlights.size() > 0) {
            List<WeakReference<Component>> removed = new ArrayList<WeakReference<Component>>(lstHighlights.size());
            for (WeakReference<Component> wr : lstHighlights) {
                Component weak = wr.get();
                if (weak == null) {
                    removed.add(wr);
                }
            }
            lstHighlights.removeAll(removed);
            setDirty(true);
        }
    }

    protected boolean contains(Component comp) {
        boolean contains = false;
        cleanReferences();
        for (WeakReference<Component> wr : lstHighlights) {
            Component weak = wr.get();
            if (weak.equals(comp)) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    protected void clearHighlights() {
        lstHighlights.clear();
        setDirty(true);
    }

    protected void addHighlight(Component comp) {
        if (comp != null) {
            if (!contains(comp)) {
                lstHighlights.add(new WeakReference<Component>(comp));
                setDirty(true);
            }
        }
    }

    public Component[] getHighlightedComponents() {
        List<Component> comps = new ArrayList<>(lstHighlights.size());
        for (WeakReference<Component> wr : lstHighlights) {
            Component comp = wr.get();
            if (comp != null) {
                comps.add(comp);
            }
        }
        return comps.toArray(new Component[comps.size()]);
    }

    protected void removeHighlight(Component comp) {
        cleanReferences();
        WeakReference<Component> toRemove = null;
        for (WeakReference<Component> wr : lstHighlights) {
            Component weak = wr.get();
            if (weak.equals(comp)) {
                toRemove = wr;
                break;
            }
        }
        if (toRemove != null) {
            lstHighlights.remove(toRemove);
            setDirty(true);
        }
    }

    public Color getHighlight() {
        return highlightColor;
    }

    /**
     * Does a recursive search of all the child components of the supplied
     * parent looking for the supplied child
     *
     * @param parent
     * @param child
     * @return true if the child resides within the parent's hierarchy,
     * otherwise false
     */
    public boolean contains(Container parent, Component child) {

        boolean contains = false;
        if (child.getParent() != null) {
            if (child.getParent().equals(parent)) {
                contains = true;
            } else {
                for (Component comp : parent.getComponents()) {
                    if (comp instanceof Container) {
                        if (contains((Container) comp, child)) {
                            contains = true;
                            break;
                        }
                    }
                }
            }
        }

        return contains;
    }

    @Override
    protected void paintLayer(Graphics2D g2, JXLayer<? extends JPanel> l) {
        super.paintLayer(g2, l);
        Graphics2D c = (Graphics2D) g2.create();
        JComponent view = l.getView();
        while (view instanceof JXLayer) {
            view = (JComponent) ((JXLayer) view).getView();
        }
        for (WeakReference<Component> wr : lstHighlights) {

            Component comp = wr.get();
            if (comp != null && contains(view, comp)) {

                // A cache here would be VERY useful, would need to be mainatined
                // against the component instance as well as the component
                // size properties...
                BufferedImage img = new BufferedImage(comp.getWidth(), comp.getHeight(), BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = img.createGraphics();
                g2d.setComposite(AlphaComposite.Clear);
                g2d.fillRect(0, 0, img.getWidth(), img.getHeight());
                g2d.setComposite(AlphaComposite.SrcOver);
                comp.printAll(g2d);
                g2d.dispose();

                BufferedImage glow = GlowEffectFactory.generateGlow(img, 8, getHighlight(), 0.75f);

                Point point = comp.getLocation();
                point = SwingUtilities.convertPoint(comp.getParent(), point, view);

                int x = point.x - ((glow.getWidth() - comp.getWidth()) / 2);
                int y = point.y - ((glow.getHeight() - comp.getHeight()) / 2);
                c.drawImage(glow, x, y, l);

            }
        }
        c.dispose();
    }
}