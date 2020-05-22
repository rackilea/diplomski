@Override
public boolean add(T e) {
    if (this._root != null){
        if(this._root.getLeftNode() == null) {
            this._root.setLeftNode(new Node<T>(e));
            return true;
        }
    }

    return false;
}