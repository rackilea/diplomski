class MyObject : Comparable<MyObject>{
 private String someString;
 private double someDouble;

 @override
 public int compareTo(MyObject o) {
     return this.someDouble.compareTo(o.getSomeDouble());
 }
}