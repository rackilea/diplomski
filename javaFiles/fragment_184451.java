//If you cannot generify the interface for some reason
interface Extractor {
    public List<? extends Matrix<?>> extract(); //explained at bottom
}

//IDEALLY, then implement Extractor<String> instead
interface Extractor<T> {
    public List<Matrix<T>> extract();
}

class InfoExtractor implements Extractor { //or Extractor<String>

    public List<Matrix<String>> extract() {
        List<Matrix<String>> matrixList = new ArrayList<>();
        matrixList.add(new Matrix<>("abc"));
        return matrixList;
    }
}