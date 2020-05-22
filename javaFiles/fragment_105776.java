private void validateOptimizedDrawing() {
    boolean layeredComponentFound = false;
    synchronized(getTreeLock()) {
        Integer layer;

        for (Component c : getComponents()) {
            layer = null;

            if(SunToolkit.isInstanceOf(c, "javax.swing.JInternalFrame") ||
                   (c instanceof JComponent &&
                    (layer = (Integer)((JComponent)c).
                                 getClientProperty(LAYER_PROPERTY)) != null))
            {
                if(layer != null && layer.equals(FRAME_CONTENT_LAYER))
                    continue;
                layeredComponentFound = true;
                break;
            }
        }
    }

    if(layeredComponentFound)
        optimizedDrawingPossible = false;
    else
        optimizedDrawingPossible = true;
}