function updateTreeContextMenu(event) {
    if (PF('treeWV') && PF('treeWV').selections && PF('treeWV').selections.length === 1) {
        $('.multiple_tree_cm').removeClass('disabled');
    } else {
        $('.multiple_tree_cm').addClass('disabled');
    }
}