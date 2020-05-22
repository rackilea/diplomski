public void drop(Component dragged, int x, int y) {
    int i = getComponentIndex(dragged);
    if(i > -1) {
        Component dest = getComponentAt(x, y);
        if(dest != dragged) {
            int destIndex = getComponentIndex(dest);
            if(destIndex > -1 && destIndex != i) {
                removeComponent(dragged);
                Object con = getLayout().getComponentConstraint(dragged);
                if(con != null) {
                    addComponent(destIndex, con, dragged);
                } else {
                    addComponent(destIndex, dragged);
                }
            }
        }
        animateLayout(400);
    } else {
        Container oldParent = dragged.getParent();
        if(oldParent != null) {
            oldParent.removeComponent(dragged);
        }
        Component pos = getComponentAt(x, y);
        i = getComponentIndex(pos);
        if(i > -1) {
            addComponent(i, dragged);
        } else {
            addComponent(dragged);
        }
        getComponentForm().animateHierarchy(400);
    }
}