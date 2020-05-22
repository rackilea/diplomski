public static double[][] deepClone(double[][] d) {
     double[][] ret = new double[d.length][];
     for(int i = 0; i < ret.length; i++)
         ret[i] = d[i].clone();
     return ret;
 }