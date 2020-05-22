interface AverageMaker<T extends Number> {
    T initialResult();
    T add(T a, Number b);
    T divideByCount(T a, int b);
}

public static <T extends Number, R extends Number> R averageValue(Iterable<T> items, AverageMaker<R> maker) {
    R res = maker.initialResult();
    int count = 0;
    for (T val : items) {
        res = maker.add(res, val);
        count++;
    }
    return maker.divideByCount(res, count);
}