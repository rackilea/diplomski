double doub = 10.0;
DoubleUnaryOperator oo = d -> {
    return doub + d;
};
double ahh = oo.applyAsDouble(.3);
UnaryOperator<Double> o = d -> {
    return ahh + d;
};
System.out.println(o.apply(.3)); //The o.apply(.3) can be assigned to new variable