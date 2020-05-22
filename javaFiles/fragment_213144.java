for(int i=0; i < n; i++) {
  IloLinearNumExpr lhs = cplex.linearNumExpr(); //lhs as in left hand side
  for(int j=0; j < n; j++) {
    lhs.addTerm(1.0, x[i][j]);        
  }   

  IloRange con = cplex.addEq(lhs, 1);
  con.setName("yourConstraintName(" + i + ")");      
}