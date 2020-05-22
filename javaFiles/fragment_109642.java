public class Repo{
     private long id;
     private String name;
     private String full_name;
     private Owner owner;
     private Parent parent;

     public class Parent{
          private String name;
          private String full_name;
          private Owner owner;
     }

     public class Owner{
          private long id;
          private String login;
     }
}