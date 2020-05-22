Result<Integer> res = new Result<Integer>() {

        Integer myInteger;

        private static final long serialVersionUID = 1L;

        @Override
        public Integer getResult() {
            return myInteger;
        }

        @Override
        public void addResult(Integer input) {
            this.myInteger = input;
        }
    };

    Integer check = res.getResult();


    Result<? extends List<Integer>> res2 = new Result<ArrayList<Integer>>() {

        ArrayList<Integer> myList;

        private static final long serialVersionUID = 1L;

        @Override
        public ArrayList<Integer> getResult() {
            return myList;
        }

        @Override 
        public void addResult(ArrayList<Integer> input) {
            this.myList = input;
        }

    };

    List<Integer> check2 = res2.getResult();