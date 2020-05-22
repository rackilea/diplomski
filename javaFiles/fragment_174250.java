UDF1 toVector = new UDF1<Seq<Float>, Vector>(){

  public Vector call(Seq<Float> t1) throws Exception {

    List<Float> L = scala.collection.JavaConversions.seqAsJavaList(t1);
    double[] DoubleArray = new double[t1.length()]; 
    for (int i = 0 ; i < L.size(); i++) { 
      DoubleArray[i]=L.get(i); 
    } 
    return Vectors.dense(DoubleArray); 
  } 
};