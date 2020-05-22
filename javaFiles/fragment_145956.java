private void myMethod(..){ 
    final Inner<Integer, Integer> inner = new Inner<Integer, Integer>() {
        public Integer apply(Integer i) {
            // whatever you want
        }
    };


    // then go:
    inner.apply(1);
    inner.apply(2);