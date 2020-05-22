public class MyAttibute extends MyObject 
{
   private NgcClass definedOnClass;//point to its parentClass

   public boolean equals(Object o){
       if(o instanceof MyAttibute){
           MyAttibute other = (MyAttibute)o;

           if(!this.definedOnClass.equals(other.definedOnClass))
                return false;//when not from the same parent they are never the same

           return this.equals2(other);
       }
       return false;
   }

   //this one should then be called from MyClass
   public boolean equals2(MyAttibute o){
       //check equality without worrying about definedOnClass
   }
}