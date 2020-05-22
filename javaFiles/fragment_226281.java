public class Node<T>{ 
...
    public void visitDepthFirst(Visitor<T> v){
        v.visit(this);
        if (left != null){
            left.visitDepthFirst(v);
        }
        if (right != null){
            right.visitDepthFirst(v);
        }
    }
}

interface Visitor<T>{
    public void visit(T t);
}
...
Node<String> root = ...;
root.visitDepthFirst(new Visitor<String>(){
    public visit(String val){
        if ("truck".equals(val)){
            // do something
        }
    }
});