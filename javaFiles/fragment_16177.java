public abstract class BaseAnt<R extends Race> {
   protected final R rInstance;
   protected BaseAnt(R rInstance) { this.R rInstance = R rInstance; }

   public final double move(double distance) {
      return distance / Instance.getSpeed();
   }

public class Ant<R extends Race> {
  ctor that calls super constructor