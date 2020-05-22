/** valueFunction selects the axis 
    reducer selects which of 2 values to retain (max/min in this case)*/
public double getExtremeValueForAxis(
   Function<Vector3D, Double> valueFunction, BinaryOperator<Double> reducer) {
     return Arrays.stream(vertices)
              .map(valueFunction)
              .reduce(reducer)
              .get();
}