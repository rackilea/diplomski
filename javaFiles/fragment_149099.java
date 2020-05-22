private boolean checkFocus(Parent p) {
    if (!p.isFocused()) {
        for (Node node :p.getChildrenUnmodifiable()) {
            if (node instanceof Parent && checkFocus((Parent) node))
                return true;
            else if (node.isFocused())
                return true;
        }
    } else 
        return true;

    return false;
}