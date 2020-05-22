public Node<Integer> question(int col, int n, Node<Integer> part_soln) {
    if (col==0) 
        return part_soln;
    else for (int row=1; row<=n; row++) {
        if (!exists(row,part_soln) && !unsafe(col,row,col+1,part_soln)) {
            Node<Integer> new_soln = new Node<Integer>(row,part_soln);
            Node<Integer> ret = question(col-1,n,new_soln);
            if (ret != null)
                return ret;
        }
    }
    return null;
}