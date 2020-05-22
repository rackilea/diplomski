public class ScatterQuadrantChart<X,Y> extends ScatterChart<X,Y> {
  public ScatterQuadrantChart(@NamedArg("xAxis")Axis<X> xAxis, 
         @NamedArg("yAxis)Axis<Y> yAxis) {
      super(xAxis, yAxis);
  } 
}