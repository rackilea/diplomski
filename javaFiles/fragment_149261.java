for (int ofs = 0; ofs < svars.length; ofs++) {
    int col = (ofs % incSize) * incSize;
    int row = ((int)(ofs / incSize)) * incSize;

    ArrayList<Variable> subBox = new ArrayList<Variable>();
    for (int ind = row; ind < row+incSize; ind++) {
        for (int ind2 = col; ind2 < col+incSize; ind2++) {
            subBox.add(svars[ind][ind2]);
        }
    }
    for (int i = 0; i < subBox.size(); i++) {
            for (int j = i + 1; j < subBox.size(); j++) {
               NotEqualConstraint c = new NotEqualConstraint(subBox.get(i), subBox.get(j));
               constraints.add(c);
            }
    }   
}