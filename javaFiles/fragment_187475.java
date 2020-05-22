while (true) {
    ThreeInts current = threeInts.get();
    ThreeInts next = somehowEvaluateNew(current);
    if (threeInts.compareAndSet(current, next) {
        break;
    }
}