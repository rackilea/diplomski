error: incompatible types: inference variable A has incompatible bounds
    float[] data = input.stream().map(x -> Float.parseFloat(x)).toArray(size -> new float[size]);
                                                                       ^
    equality constraints: float
    upper bounds: Object
  where A is a type-variable:
    A extends Object declared in method <A>toArray(IntFunction<A[]>)
1 error