public class BinaryTree<E extends Comparable<? super E>> {

    protected class Node<T extends E> {
        protected T data;
        protected Node<T> left;
        protected Node<T> right;

        protected Node(T data) {
            this.data = data;
        }

        protected Node<T> insert(T data) {
            if (data.compareTo(this.data) <= 0) {
                if (left == null) {
                    this.left = new Node(data);
                } else {
                    this.left = this.left.insert(data);
                }
            } else {
                if (right == null) {
                    this.right = new Node(data);
                } else {
                    this.right = this.right.insert(data);
                }
            }

            return this;
        }

        protected boolean search(T data) {
            if (data.compareTo(this.data) == 0) {
                return true;
            }

            if (this.left != null && data.compareTo(this.data) <= 0) {
                return this.left.search(data);
            } else if (this.right != null && data.compareTo(this.data) > 0) {
                return this.right.search(data);
            }

            return false;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String divider = ", ";

            if (this.left != null) {
                sb.append(this.left.toString()).append(divider);
            }

            sb.append(String.valueOf(this.data)).append(divider);

            if (this.right != null) {
                sb.append(this.right.toString()).append(divider);
            }

            if (sb.length() > divider.length() - 1) {
                sb.setLength(sb.length() - divider.length());
            }

            return sb.toString();
        }
    }

    protected Node<E> root;

    public Node<E> insert(E data) {
        if (root == null) this.root = new Node(data);
        else {
            this.root = this.root.insert(data);
        }
        return this.root;
    }

    public Node<E> remove(E data) {
        return null; // TODO: Implement this
    }

    public boolean search(E data) {
        return root != null && this.root.search(data);
    }

    @Override
    public String toString() {
        return String.valueOf(this.root);
    }
}