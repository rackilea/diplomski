import ilog.concert.*; 
import ilog.cplex.*; 
public class Example { 
public static void main(String[] args) { 
    try { 
      for(int i = 1;i <= 5;i++){ // Loop with indices that you may use to create your constraints and objective function.
      IloCplex cplex = new IloCplex(); // Cause of memory leak
      double[]    lb = {0.0, 0.0, 0.0}; 
      double[]    ub = {40.0, Double.MAX_VALUE, Double.MAX_VALUE}; 
      IloNumVar[] x  = cplex.numVarArray(3, lb, ub); 
      double[] objvals = {1.0, 2.0, 3.0}; 
       cplex.addMaximize(cplex.scalProd(x, objvals)); 
      cplex.addLe(cplex.sum(cplex.prod(-1.0, x[0]), 
                            cplex.prod( 1.0, x[1]), 
                            cplex.prod( 1.0, x[2])), 20.0); 
      cplex.addLe(cplex.sum(cplex.prod( 1.0, x[0]), 
                            cplex.prod(-3.0, x[1]), 
                            cplex.prod( 1.0, x[2])), 30.0); 
      if ( cplex.solve() ) { 
        cplex.out().println("Solution status = " + cplex.getStatus()); 
        cplex.out().println("Solution value  = " + cplex.getObjValue());
        double[] val = cplex.getValues(x); 
        int ncols = cplex.getNcols(); 
        for (int j = 0; j < ncols; ++j) 
           cplex.out().println("Column: " + j + " Value = " + val[j]); 
      }
      cplex.end(); 
    }
    }
    catch (IloException e) { 
System.err.println("Concert exception '" + e + "' caught"); 
    }
  }
}