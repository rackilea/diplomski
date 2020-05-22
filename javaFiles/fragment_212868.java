public Node map(F f){
            Node start = new Node(f.apply(item), null);
            Node current = start;

            for(Node originalNode = this.next; originalNode != null; originalNode = originalNode.next) {

                Node copyOfNextNode =new Node(f.apply(originalNode.item), null);
                current.next = copyOfNextNode;
                current = current.next;
            }
            return start;
        }

        /* Creates a new Node with all elements that match predicate p */
        public Node filter(P p){
            Node start = null;
            Node current = null;

            for(Node originalNode = this; originalNode != null; originalNode = originalNode.next) {

                if(p.filter(originalNode.item)) {
                    Node copyOfNextNode =new Node(originalNode.item, null);
                    if(current == null) {
                        current = copyOfNextNode;
                        start = current;
                    } else {
                        current.next = copyOfNextNode;
                        current = current.next;
                    }
                }
            }
            return start;
        }