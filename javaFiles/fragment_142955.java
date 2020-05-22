private <T> void fireCallback(final T t) {
    System.out.println("fireCallback");
}
private <T> void expiredCallback(final T t) {
    System.out.println("expiredCallback");
}