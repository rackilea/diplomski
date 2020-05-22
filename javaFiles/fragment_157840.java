@FunctionalInterface
interface Processable<T> {
    public T apply() throws Throwable;
}


private <T> T process(Processable<T> aProcessable) {
    try {
        return aProcessable.apply();
    } catch (MyCheckedException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    } catch (Throwable e) {
        e.printStackTrace();
    }

    return null;
}