import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.optim.InitialGuess;
import org.apache.commons.math3.optim.MaxEval;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.optim.SimpleBounds;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.noderiv.BOBYQAOptimizer;

public class JavaApplication1 {

    public static void main(String[] args) {
        final MultivariateFunction fn = new MultivariateFunction() {
            @Override
            public double value(double[] point) {
                return 0;
            }
        };

        BOBYQAOptimizer optimizer = new BOBYQAOptimizer(2 * 3 + 1 + 2); // 2*point.length + 1+additional
        final PointValuePair optimum = optimizer.optimize(new MaxEval(150), new ObjectiveFunction(fn),
                GoalType.MAXIMIZE, new InitialGuess(new double[] { 1.0, 1.0, 1.0 }),
                new SimpleBounds(new double[] { 0.0, 0.0, 0.0 }, new double[] { 3.5, 3.5, 3.5 }));

        double[] point = optimum.getPoint();
        System.out.print("point= ");
        for (int i = 0; i < point.length; i++)
            System.out.print("  " + point[i]);
        System.out.println(" ");
        System.out.println("value = " + optimum.getValue());

    }

}