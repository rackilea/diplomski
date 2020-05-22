class EffectList<EffectType extends Effect> {
  public EffectList(Class<EffectType> clazz) {
    try {
      mEffect = clazz.getConstructor().newInstance();
    } catch (Exception ex) {
      // suppressing Exceptions - in production code you should handle it better
      throw new RuntimeException(ex);
    }
    // ...
  }

  // ...
}