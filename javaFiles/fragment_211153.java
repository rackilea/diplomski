class TupleComparator implements Comparator<Tuple2<Double,Long>>, Serializable {
private static final long serialVersionUID = 1L;
@Override
public int compare(Tuple2<Double, Long> v1, Tuple2<Double, Long> v2) {
    if (v1._1().compareTo(v2._1()) == 0) {
        return v1._2().compareTo(v2._2());
    }
        return  v2._2().compareTo(v1._2());
    }
}