class InfoExtractor implements Extractor{

    // The problem is actually here
    public <T> List<Matrix<T>> extract(){ 
       List<Matrix<T>> matrixList = new ArrayList<>(); //and here

        // "The problem is here!!!!"
        matrixList.add(new Matrix<String>("abc")); 
    }
}