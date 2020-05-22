// create the conversion object and save a reference
IloConversion makeInteger cplex.conversion(x, IloNumVarType.Int);

// To modify the model, add the conversion object to the model
cplex.add(makeXInteger);

// solve the model, 
IloBool success = cplex.solve();

// revert the model back to continuous
cplex.remove(makeXInteger);