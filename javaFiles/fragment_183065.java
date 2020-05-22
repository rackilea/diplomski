class YourConsumer {
  @Inject Map<Integer, Provider<I>> iMap;

  public void yourMethod(int iIndex) {
    // get an I implementor
    I i = iMap.get(iIndex).get();
    // ...
  }
}