scala.collection.immutable.Range rangeMscala = 
  scala.collection.immutable.Range$.MODULE$.apply(1, 10);

SparkContext sc = new SparkContext();

RDD dataSetMscala = 
  sc.parallelize(rangeMscala, 3, scala.reflect.ClassTag$.MODULE$.Object());