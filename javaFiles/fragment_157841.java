@FunctionalInterface
interface Processable {
    public Object apply() throws Throwable;
}


private Object process(Processable aProcessable) {
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