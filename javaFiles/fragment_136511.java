public static class Pipeline<IN, OUT> {
   //...
   public<A> Pipeline<OUT,A> add(Step<IN,A> step) {
     pipelineSteps.add(step);
     return (Pipeline<OUT,A>)this;
   }
}