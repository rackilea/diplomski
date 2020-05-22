public class PoincareTransform implements Transform {
   private Matrix matrix;
   public Transform compose(Transform t) {
     if (!t instanceof PoincarTransform) {
       // Throw an exception, or some other meaningful error.
     }
     PoincarTransform p = (PoincarTransform)t;
     ...
   }
}