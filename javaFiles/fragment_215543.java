import ilog.concert.*; 
import ilog.cplex.*; 
static public class Application { 
    static public main(String[] args) { 
       try {
         IloCplex cplex = new IloCplex(); 
         // create model and solve it 
       } catch (IloException e) { 
          System.err.println("Concert exception caught: " + e); 
       }
     }
   }