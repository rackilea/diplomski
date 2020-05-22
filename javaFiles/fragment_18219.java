class David {
     public String getName() {
         return "David";
     }
     // private method... nobody but David's "instance" can use it.. 
     private int getAge() {
         return 19;
     } 
     // Here the call to "getAge()" will succeed, because it is visible 
     // inside the class 
     public boolean hasSameAgeAs( David otherDavid ) {
         return this.getAge() == otherDavid.getAge();
     }
 }