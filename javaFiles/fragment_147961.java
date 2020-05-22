public class TreeTask extends RecursiveAction {
    private final TreeNode node;
    private final int level;

    public TreeTask(TreeNode node, int level) {
        this.node = node;
        this.level = leve;
    }

    public void compute() {
        // It makes sense to switch to single-threaded execution after some threshold
        if (level > THRESHOLD) function(node);

        if (node.children != null && !node.children.isEmpty()) {
            List<TreeTask> subtasks = new ArrayList<TreeTask>(node.children.size());
            for (TreeNode n : node.children) {
                // do some stuff
                subtasks.add(new TreeTask(n, level + 1));
            }
            invokeAll(subtasks); // Invoke and wait for completion
        } else {
            //do some other processing
        }
    }
}

...
ForkJoinPool p = new ForkJoinPool(N_THREADS);
p.invoke(root, 0);