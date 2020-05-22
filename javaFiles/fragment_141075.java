class Node{
    ... // variables and constructor

    @Override
    public boolean equals(Object o){
        return (o != null) && (o instanceof Node) && (data.equals(((Node) o).data);
    }

    @Override
    public int hashCode(){
        return Objects.hash(data);
    }
}