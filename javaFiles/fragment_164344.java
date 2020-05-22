static UDF1<WrappedArray<WrappedArray<Double>>, List<Double>> getValue = new UDF1<WrappedArray<WrappedArray<Double>>, List<Double>>() {
public List<Double> call(WrappedArray<WrappedArray<Double>> data) throws Exception {
        List<Double> doubleList = new ArrayList<Double>();
        for(int i=0; i<data.size(); i++){
            doubleList.addAll(JavaConversions.seqAsJavaList(data.apply(i)));
        }
        return doubleList;
    }
}