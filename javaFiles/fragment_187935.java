retval = cplex.solve();
// verify that the solve was successful

// change coeficients on constraints (or in the objective)
cplex.setLinearCoef(constraint, newCoef, variable);
cplex.setLinearCoef(objective, newObjCoef, variable);

// change right bounds on constraints
constraint.setBounds(newLB, newUB);

// change variable bounds
var.setBounds(newLB, newUB);

retval = cplex.solve();
// verify the solve