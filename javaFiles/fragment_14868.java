public void num(Node n) {


        if(n.getleft()!=null)num(n.getleft());
        if(n.getRight()!=null)num(n.getRight());
        if(n.isLeaf())
        {
            n.assignIndex(ini);
            ini++;
        }

}