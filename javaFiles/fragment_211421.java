import java.util.Arrays;

import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.NelderMeadSimplex;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.SimplexOptimizer;
import org.apache.commons.math3.util.FastMath;

public class SimplexOptimizerExample
{
    public static void main(String[] args)
    {
        SimplexOptimizer optimizer = new SimplexOptimizer(1e-10, 1e-30);
        final FourExtrema fourExtrema = new FourExtrema();

        final PointValuePair optimum =
            optimizer.optimize(
                new MaxEval(100), 
                new ObjectiveFunction(fourExtrema), 
                GoalType.MINIMIZE, 
                new InitialGuess(new double[]{ -3, 0 }), 
                new NelderMeadSimplex(new double[]{ 0.2, 0.2 }));

        System.out.println(Arrays.toString(optimum.getPoint()) + " : "
            + optimum.getSecond());
    }

    private static class FourExtrema implements MultivariateFunction
    {
        // The following function has 4 local extrema.
        final double xM = -3.841947088256863675365;
        final double yM = -1.391745200270734924416;
        final double xP = 0.2286682237349059125691;
        final double yP = -yM;
        final double valueXmYm = 0.2373295333134216789769; // Local maximum.
        final double valueXmYp = -valueXmYm; // Local minimum.
        final double valueXpYm = -0.7290400707055187115322; // Global minimum.
        final double valueXpYp = -valueXpYm; // Global maximum.

        public double value(double[] variables)
        {
            final double x = variables[0];
            final double y = variables[1];
            return (x == 0 || y == 0) ? 0 : FastMath.atan(x)
                * FastMath.atan(x + 2) * FastMath.atan(y) * FastMath.atan(y)
                / (x * y);
        }
    }
}