return (t,u) -> {
    try {
        if(resultB.isDone() && resultC.isDone()) return optimistic.get();
        return optimistic.get(t, u);
    } catch (InterruptedException | TimeoutException ex) {
        return combine(resultA.join(), resultB.getNow(fallbackB),
                                       resultC.getNow(fallbackC));
    }
};