public class User{
   private String name;

   @JsonIgnore
   private String dummy;

   public void getName(){return name;}
   public void setName(name){this.name = name;}
   public void getDummy(){return dummy;}
   public void setDummy(dummy){this.dummy= dummy;}

}