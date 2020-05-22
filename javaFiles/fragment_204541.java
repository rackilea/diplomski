public Double[] intersect(Double[] a, Double[] b) {
        List<Double> aList =  Arrays.asList(a); // List<double[]> this is bad!
        List<Double> bList =  Arrays.asList(b);
        aList.retainAll(bList);
        return aList.toArray(new Double[aList.size()]);            
}