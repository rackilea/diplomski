add(Child child) {
    child.setParent0(this);
    children.add(child);
}

remove(Child child) {
    child.setParent0(null);
    children.remove(child);
}