final class TreeNode {
    private final Iterable<TreeNode> children;

    TreeNode(Iterable<TreeNode> aChildren) {
        children = aChildren;
    }

    Iterable<TreeNode> getChildren() {
        return children;
    }

    void postorder(TreeNodeIterator iterator) {
        postorderTraverse(this, iterator);
    }

    private void postorderTraverse(TreeNode node, TreeNodeIterator iterator) {
        for (TreeNode child : children) {
            postorderTraverse(child, iterator);
        }
        iterator.visit(node);
    }

    void postorderParallel(TreeNodeIterator iterator) {
        new ForkJoinPool().invoke(new VisitNodeAction(iterator, this));
    }

    interface TreeNodeIterator {
        void visit(TreeNode child);
    }

    private class VisitNodeAction extends RecursiveAction {
        private final TreeNodeIterator iterator;
        private final TreeNode node;

        private VisitNodeAction(TreeNodeIterator iterator, TreeNode node) {
            this.iterator = iterator;
            this.node = node;
        }

        @Override
        protected void compute() {
            List<RecursiveAction> tasks = new LinkedList<RecursiveAction>();
            for (TreeNode child : children) {
                tasks.add(new VisitNodeAction(iterator, child));
            }
            invokeAll(tasks);
            iterator.visit(node);
        }
    }
}