public class TreeNode
    {
        public TreeNode Left;
        public TreeNode Right;
        public int Value;
    }

    private void DoStuff()
    {
        TreeNode Root = new TreeNode {Value = 0};
        for (var i = 1; i < 10; ++i)
        {
            TreeInsert(Root, new TreeNode {Value = i}, i);
        }
        PreOrder(Root, 0);
    }

    private void TreeInsert(TreeNode root, TreeNode item, int node)
    {
        int parent = (node - 1)/2;
        if (parent == 0)
        {
            if (root.Left == null)
                root.Left = item;
            else
                root.Right = item;
        }
        else
        {
            TreeNode child = ((parent%2) == 1) ? root.Left : root.Right;
            TreeInsert(child, item, parent);
        }
    }

    private void PreOrder(TreeNode root, int level)
    {
        if (root == null) return;
        Console.WriteLine("{0}{1}", new String('-', 2*level), root.Value);
        PreOrder(root.Left, level+1);
        PreOrder(root.Right, level + 1);
    }