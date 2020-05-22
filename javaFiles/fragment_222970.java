@Entity
public class Employee {
     // all the common employee fields go here 
     //

     // the discriminator column on Employee class lets you be specific in your queries          
     private Integer type; 

     @Emebded 
     private Internal internal; // has the fields that are internal

     @Embeded
     private External external; // has the fields that are external 

     equals & hashcode that compare based on the discriminator type and other fields 
}