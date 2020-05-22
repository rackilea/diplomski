public void combine(){
    remove();
    Square newParent = new Square(pane, parent, x, y, w, h, id);
    if (parent != null) {
        parent.setChild(newParent);
    }
}

public void setChild(Cell newChild) {
    grid[newChild.id] = newChild;
}