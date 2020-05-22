IloLinearNumExpr obj = cplex.linearNumExpr();

for(int k=0; k<grossK.length; k++){
    obj.addTerm(1.0, trueck[k]);
    obj.addTerm(-1.0, time[k]);
}

cplex.addMinimize(obj);