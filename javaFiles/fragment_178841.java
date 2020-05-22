@Entity
class User{
//mandatory fields
private Long id;
private String userName;

//not mandatory fields:
private Date registrationDate;
private String nickName;

   public User(){//it's default constructor for hibernate entity creation 
   }

   public User( Long id ,String userName){ // you can create entity whenever when you want to create entity
....
   }
}