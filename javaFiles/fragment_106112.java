public boolean helper(TreeNode root)
    {
        if (root.getLeftNode() == null)
        {
            if (root.getRightNode() == null)
                return true;
            else return helper(root.getRightNode(), root);
        }
        //if everything branching from leftNode is in order
        else if(helper(root.getLeftNode(), root))
        {
            if (root.getRightNode() != null)
                return helper(root.getRightNode(), root);
            else return true;
        }
        else return false;
    }

    private boolean helper(TreeNode currentNode, TreeNode previousNode)
    {
        //Test leftNode
        if (currentNode == previousNode.getLeftNode())
        {
            if (currentNode.getData() > previousNode.getData()) return false;
            else
            {
                if (currentNode.getLeftNode() == null)
                {
                    if (currentNode.getRightNode() == null)
                        return true;
                    else return helper(currentNode.getRightNode(), currentNode);
                }
                //if everything branching from leftNode is in order
                else if(helper(currentNode.getLeftNode(), currentNode))
                {
                    if (currentNode.getRightNode() != null)
                        return helper(currentNode.getRightNode(), currentNode);
                    else return true;
                }
                else return false;
            }
        }
        //Test rightNode
        else
        {
            if (currentNode.getData() < previousNode.getData()) return false;
            else
            {
                if (currentNode.getLeftNode() == null)
                {
                    if (currentNode.getRightNode() == null)
                        return true;
                    else return helper(currentNode.getRightNode(), currentNode);
                }
                //if everything branching from leftNode is in order
                else if(helper(currentNode.getLeftNode(), currentNode))
                {
                    if (currentNode.getRightNode() != null)
                        return helper(currentNode.getRightNode(), currentNode);
                    else return true;
                }
                else return false;
            }
        }
    }