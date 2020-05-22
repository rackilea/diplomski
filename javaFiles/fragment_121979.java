for (User ui : list) {
    user = new DefaultMutableTreeNode(ui.getUserName()) {
        @Override
        public boolean isLeaf() {
            return false;
        }
    };
    category.add(user);
}