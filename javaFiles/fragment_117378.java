// suitable parent of the invoker, to add the popup
Container parent = null;

if (owner != null) {
    parent = (owner instanceof Container? (Container)owner : owner.getParent());
}

// Try to find a JLayeredPane and Window to add
for (Container p = parent; p != null; p = p.getParent()) {
    if (p instanceof JRootPane) {
        if (p.getParent() instanceof JInternalFrame) {
        // Continue, so that if there is a higher JRootPane, we'll
        // pick it up.
            continue;
        }

        parent = ((JRootPane)p).getLayeredPane();
        // the implied assumption for correct visuals is that the assert below passes
        // would fail if the invoker is
        // located in the glassPane hierarchy
        assertTrue(SwingUtilities.isDescendingFrom(owner, parent);
    } else ....
    }
    // with the failing assumption above, the popup is inserted below its invoker 
    if (parent instanceof JLayeredPane) {
        parent.add(component, JLayeredPane.POPUP_LAYER, 0);
    } else ...   
}