public class Entity {

     private Date modifiedOn;

     @PreUpdate 
     @PrePersist
     public void updateModified() {
         modifiedOn = new Date();
     }
}