public <T> List<T> cleanData(List<T> data, List<UnaryOperator<T>> cleanOps) {
    cleanOps.stream()
        .reduce((f1,f2) -> t -> f2.apply(f1.apply(t)))
        .ifPresent(data::replaceAll);
    return data;
}