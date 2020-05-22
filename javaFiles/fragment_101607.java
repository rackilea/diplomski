import  org.mariuszgromada.math.mxparser.*;
import  org.mariuszgromada.math.mxparser.Constant;

  Constant mp = new Constant("mp",0.5);
        String mpString = Double.toString(mp.getConstantValue());
        String equation = "min(max(1,6)," + mpString +")";
        Expression e = new Expression(equation);
        System.out.println(e.calculate());