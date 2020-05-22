myRDD2.foreachRDD(new VoidFunction<JavaRDD<String>>() {
    private static final long serialVersionUID = -4895942417886562330L;

    public void call(JavaRDD<String> rdd) throws Exception {
        rdd.foreachPartition(new VoidFunction<Iterator<String>>() {
            private static final long serialVersionUID = -1L;
            public void call(Iterator<String> rdd) throws Exception {
              while (t.hasNext()) {
              System.out.println(t.next());
            }
        }

    }
});