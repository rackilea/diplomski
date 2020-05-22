@Override
public int compare(Node n1, Node n2) {
    // TODO Auto-generated method stub
    if(n1.cost > n2.cost) return 1;
    else if(n1.cost < n2.cost) return -1;
    else return ( n1.equals(n2)? 0 : 1);
}