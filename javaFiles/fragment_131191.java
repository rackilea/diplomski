public void ids(int limit)
    {
        for (int n = 1; n <= limit; ++n)
        {
            dfs(n);
        }
    }

public void dfs(int limit)
    {
        Stack s=new Stack();
        s.push(this.rootNode);
        rootNode.visited=true;
        while(!s.isEmpty())
        {
            Node n=(Node)s.peek();

            if (stack.size() == limit)
            {
                printNode(n);
                s.pop();
            } else {
                Node child=getUnvisitedChildNode(n);
                if(child!=null)
                {
                    child.visited=true;
                    s.push(child);
                }
                else
                {
                    s.pop();
                }
            }
        }
        clearNodes();
    }