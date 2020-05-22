public class Node<T>{
    private T data;
    private List<Node<T>> parents;
    private List<Node<T>> children = new ArrayList<>();//this can be initialized because a node will not start with children
    public Node(T data){//adding a node without parents
        this.data = data;
        parents = new ArrayList<>();//make parents an empty ArrayList so other methods won't break with a null value
    }
    public Node(T data, List<Node<T>> parents){//adding a node with parents
        this.data = data;
        this.parents = parents;
    }

    //search methods
    public List<Node<T>> getChildren(){return children;}//return only direct children
    public List<Node<T>> getChildren(int level){return getChildren(new ArrayList<>(Collections.singletonList(this)),new ArrayList<>(),level);}//convenience method to find only this node's children to a certain level
    public List<Node<T>> getChildren(List<Node<T>> find, List<Node<T>> found, int level){//level can be -1 to search through all children or a positive integer to only search the first n level of children.
        if(level!=0){//setting level to -1 will never stop the search until all children have been found because level only goes down, because the level will never reach zero
            for(Node<T> node:find){//can find the children of multiple nodes
                if(node.hasChild()) {
                    for (Node<T> child : node.getChildren()) {
                        if (!found.contains(child)) {//trees can intersect, so the child may have already been found, so only add if it hasn't
                            found.add(child);
                        }
                    }
                    getChildren(node.getChildren(),found,level--);//recursively find the remaining children of the current node
                }
            }
        }
        return found;
    }
    //a method that finds parents can be implemented by modifying the getChildren() methods

    //examples of other methods that can be added
    public T getData(){return data;}
    public boolean hasChild(){return children.size()>0;}
    void addChild(Node<T> node){children.add(node);}
    void addChildren(List<Node<T>> nodes){children.addAll(nodes);}
    public List<Node<T>> getParents(){return parents;}
    public boolean hasParent(){return parents.size()>0;}
    void addParent(Node<T> node){parents.add(node);}
    void addParent(List<Node<T>> nodes){parents.addAll(nodes);}
}