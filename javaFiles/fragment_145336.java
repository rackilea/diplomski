public boolean shouldIterateChildren() {
    if (tree.isLeaf())
        return false;
    else {
        char separatorChar = UINamingContainer.getSeparatorChar(FacesContext.getCurrentInstance());
        String clientId = tree.getClientId();
        boolean render = false;
        for (String idToRender : FacesContext.getCurrentInstance().getPartialViewContext().getRenderIds()) {
            // render the tree if you explicitly mention either the client id (e.g. "menuForm:tree") or the parent component client id (e.g. "menuForm")
            // note that when clicking on an object in the tree, the following render target is requested: menuForm:tree@selection
            if (clientId.equals(idToRender) || clientId.matches(idToRender + separatorChar + ".*")) {
                render = true;
                break;
            }
        }
        // always render if it's not a postback
        return render || !FacesContext.getCurrentInstance().isPostback();
    }
}