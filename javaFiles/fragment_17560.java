public MathObject add(MathObject that){
    if (that instanceof Constant)
        return add((Constant) that);
    else
        that.add((Constant)this); // note that the casting here only makes
                                  // sense if MathObject has an add method
                                  // that takes a Constant. otherwise is makes
                                  // no difference
}