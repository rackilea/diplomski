@Listen("onSelect = #tree")
    public void onSelect(SelectEvent<Treeitem, String> event) {
        Treeitem ref = event.getReference();
        Set<Treeitem> newSelection = new HashSet<Treeitem>(event.getSelectedItems());
        if (ref.isSelected()) {
            if (selected != null) {
                Set<Treeitem> deselected = new HashSet<Treeitem>(selected);
                deselected.removeAll(newSelection);
                for (Treeitem t : deselected) {
                    Clients.log("Deselected " + t.getLabel());
                }
            }
            Clients.log("Selected " + ref.getLabel());
        } else {
            Clients.log("Deselected " + ref.getLabel());
        }
        selected = newSelection;
    }