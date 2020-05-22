private static final class Percentile extends Fixed2ArgFunction {

protected Percentile() {
}

public ValueEval evaluate(int srcRowIndex, int srcColumnIndex, ValueEval arg0,
        ValueEval arg1) {
    double dn;
    try {
        ValueEval ve1 = OperandResolver.getSingleValue(arg1, srcRowIndex, srcColumnIndex);
        dn = OperandResolver.coerceValueToDouble(ve1);
    } catch (EvaluationException e1) {
        // all errors in the second arg translate to #VALUE!
        return ErrorEval.VALUE_INVALID;
    }
    if (dn < 0 || dn > 1) { // has to be percentage
        return ErrorEval.NUM_ERROR;
    }

    double result;
    try {
        double[] ds = ValueCollector.collectValues(arg0);
        int N = ds.length;
        double n = (N - 1) * dn + 1;
        if (n == 1d) {
            result = StatsLib.kthSmallest(ds, 1);
        } else if (n == N) {
            result = StatsLib.kthLargest(ds, 1);
        } else {
            int k = (int) n;
            double d = n - k;
            result = StatsLib.kthSmallest(ds, k) + d
                    * (StatsLib.kthSmallest(ds, k + 1) - StatsLib.kthSmallest(ds, k));
        }

        NumericFunction.checkValue(result);
    } catch (EvaluationException e) {
        return e.getErrorEval();
    }

    return new NumberEval(result);
}