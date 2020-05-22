enum Mode {
  on {
      public <E> E accept( ModeVisitor<E> visitor ) {
         return visitor.visitOn();
      }
  },
  off {
      public <E> E accept( ModeVisitor<E> visitor ) {
         return visitor.visitOff();
      }
  },
  standby {
      public <E> E accept( ModeVisitor<E> visitor ) {
         return visitor.visitStandby();
      }
  }

  public abstract <E> E accept( ModeVisitor<E> visitor );

  public interface ModeVisitor<E> {
      E visitOn();
      E visitOff();
      E visitStandby();
  }
}