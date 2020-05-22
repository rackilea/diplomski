import com.google.ortools.linearsolver.MPConstraint;
import com.google.ortools.linearsolver.MPObjective;
import com.google.ortools.linearsolver.MPSolver;
import com.google.ortools.linearsolver.MPVariable;
import java.util.ArrayList;

public class LinearAssignment {
    public static void main(String[] args) {
        System.loadLibrary("jniortools");
        var solver = new MPSolver(
                "LinearAssignmentProblem", MPSolver.OptimizationProblemType.valueOf("CBC_MIXED_INTEGER_PROGRAMMING"));

        // Define the variables and the objective function
        var x = new ArrayList<ArrayList<MPVariable>>();
        var objective = solver.objective();
        int n = 5;
        for (int i = 0; i < n; i++) {
            var inner = new ArrayList<MPVariable>();
            for (int j = 0; j < n; j++) {
                var xij = solver.makeBoolVar(String.format("x%d%d", i, j));
                objective.setCoefficient(xij, (i+1)*(j+1));
                inner.add(xij);
            }
            x.add(inner);
        }

        // Add the constraint that sum_j x_{ij} = 1 for every i.
        for (int i = 0; i < n; i++) {
            var ci = solver.makeConstraint(1, 1);
            for (int j = 0; j < n; j++) ci.setCoefficient(x.get(i).get(j), 1);
        }

        // Add the constraint that sum_i x_{ij} = 1 for every j.
        for (int i = 0; j < n; j++) {
            var cj = solver.makeConstraint(1, 1);
            for (int i = 0; i < n; i++) cj.setCoefficient(x.get(i).get(j), 1);
        }

        // Run the solver
        solver.solve();

        // Print the results
        System.out.println("Objective at minimum = " + solver.objective().value());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(String.format("x%d%d = %d, ", i, j, (int) x.get(i).get(j).solutionValue()));
            System.out.println();
        }
    }
}