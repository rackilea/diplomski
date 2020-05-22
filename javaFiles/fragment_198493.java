public static class Iterator<E>
    {
        private Stack<BSTNode<E>> stack;

        public Iterator(BSTNode<E> node)
        {
            this.stack = new Stack<>();
            while (node != null)
            {
                stack.push(node);
                node = node.left;
            }
        }
        public boolean hasNext()
        {
            return !stack.isEmpty();
        }
        public E next()
        {
            BSTNode<E> goodDays = stack.pop();
            E result = goodDays.data;
            if (goodDays.right != null)
            {
                goodDays = goodDays.right;
                while (goodDays != null)
                {
                    stack.push(goodDays);
                    goodDays = goodDays.left;
                }
            }
            return result;
        }
    }