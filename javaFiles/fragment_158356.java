double x_input[]={3,0,4,3,4,4,3,2,3,0};
    // x_input generated from Poisson(3)


    MultivariateFunction f =(double[] lam) -> (poisson_loglik(lam,x_input));
    MultivariateOptimizer optim= new BOBYQAOptimizer(x_input.length * 2);
    PointValuePair result;
    result = optim.optimize(new MaxEval(1000),
            new ObjectiveFunction(f),
            GoalType.MAXIMIZE,
            new InitialGuess(new double[] {3})
    );