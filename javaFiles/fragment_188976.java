AbstractFunction2<Object, Object, BoxedUnit> f = new AbstractFunction2<Object, Object, BoxedUnit>() {
        public BoxedUnit apply(Object t1, Object t2) {
            System.out.println("Index:" + t1 + "      Value:" + t2);
            return BoxedUnit.UNIT;
        }
    };

    Vector sv = Vectors.sparse(3, new int[]{0, 2}, new double[]{1.0, 3.0});
    sv.foreachActive(f);