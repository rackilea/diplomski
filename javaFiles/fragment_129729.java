public aspect ShapesAreDirtyThings {

   private boolean Shape.dirty;

   after(Shape s) : execution(* Shape+.set*(..)) {
       s.dirty = true;
       // Set some other global field, start a thread to communicate 
       // to other users about the change, whatever .. 
   } 

   public boolean Shape.isDirty() {
       return s.dirty;
   }

   public boolean Shape.findDirtyChildren() { // whatever
}