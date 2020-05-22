public class FastenerBag {

  private Map<FastenerType, AtomicInteger> fasteners = new EnumMap<FastenerType, AtomicInteger>(FastenerType.map);

  FastenerBag(){
    // init your ints to zero
  }

  public void addFastenersFor(VerandaPart part){
    for (FastenerType type : FastenerType.values()){
      fasteners.get(type).addAndGet(part.getRequiredFasteners().get(type));
    }
  }

}