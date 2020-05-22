interface Renderable {
   void render();
}

interface RenderDelegator {
   Renderable getRenderable();
   void setRenderable(Renderable renderable);
}

abstract class Vehicle implements RenderDelegator {
   private Renderable renderable;

   @Override
   public Renderable getRenderable() {
      return renderable;
   }

   @Override
   public void setRenderable(Renderable renderable) {
      this.renderable = renderable;
   }

   public abstract void drive();
}

class Car extends Vehicle {
   @Override
   public void drive() {
      // TODO finish!
   }

}