static UDF1<WrappedArray<WrappedArray<Integer>>, List<Integer>> getValue = new UDF1<WrappedArray<WrappedArray<Integer>>, List<Integer>>() {
      public List<Integer> call(WrappedArray<WrappedArray<Integer>> data) throws Exception {
        List<Integer> intList = new ArrayList<Integer>();
        for(int i=0; i<data.size(); i++){
            intList.addAll(JavaConversions.seqAsJavaList(data.apply(i)));
        }
        return intList;
    }
};