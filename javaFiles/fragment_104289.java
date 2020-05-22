class Base {
   public void Blah() {
     //code
   }
}

class Extended extends Base {
   private int SuperSensitiveVariable;

   public setSuperSensistiveVariable(int value) {
     this.SuperSensistiveVariable = value;
   }

   public void Blah() {
     //code
   }
}

//elsewhere
Base b = new Extended();
Extended e = new Extended();