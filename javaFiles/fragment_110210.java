public abstract class BodyPart {

  private List<? extends BodyPart> _linkedParts;

  public <T extends BodyPart> T getPart(Class<? extends T> clazz) {
    for(BodyPart part : _linkedParts) {
      if(clazz.isInstance(part)) { 
        return clazz.cast(part);
      }
      T childPart = part.getPart(clazz);
      if(childPart != null) {
        return childPart;
      }
    }
    return null;
  }
}