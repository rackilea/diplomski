lowestCommonAncestor(root=1, p=2, q=3):
    if (root == null || root == p || root == q) return root;
    //     false           false        false

    left = lowestCommonAncestor(2, 2, 3):
               if (root == null || root == p || root == q) return root
               //     false            true                return 2

    right = lowestCommonAncestor(null, 2, 3):
                if (root == null || root == p || root == q) return root;
                //      true                                return null

    return left != null && right != null ? root : left == null ? right : left;
    //         true        false                     false             : 2