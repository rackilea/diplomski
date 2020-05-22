public class Container 
{
   private String type;

   private AAnimal animal;

   public String getType()
   {
      return type;
   }

   public void setType(String type)
   {
      this.type = type;
   }

   public AAnimal getAnimal()
   {
      return animal;
   }

   @JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.EXTERNAL_PROPERTY, property="type")
   public void setAnimal(AAnimal animal)
   {
      this.animal = animal;
   }
}