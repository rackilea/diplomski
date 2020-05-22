<T> double sumUpGroup(Collection<? extends T> entityList, 
    Function<? super T, Integer> dbAccessor, 
    Function<? super T, Double> amountAccessor, 
    int from, int to) {

    double sum = 0;
    for (T entity : entityList) {
        int value = dbAccessor.apply(entity);
        if (value >= from && value <= to) {
            sum += amountAccessor.apply(entity);
        }
    }

    return sum;
}