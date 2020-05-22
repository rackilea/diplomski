public boolean setTreeItem(Employee emp, TreeItem<Employee> root_tree) {
    if (emp.equals(root_tree.getValue())) {
        root_tree.setExpanded(false);
        return true;
    } else {
        for (TreeItem<Employee> emps : root_tree.getChildren()) {
            if (setTreeItem(emp, emps)) {
                // expand & return true, if item is a descendant of the current item
                root_tree.setExpanded(true);
                return true;
            }
        }
        return false; // set expanded to false before returning here?
    }
}