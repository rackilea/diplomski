/***************** Models ****************/

class Person {
 @Expose
 public int age;
 @Expose
 public String name;
 @Expose
 @OneToMany(mappedBy="owner")
 public Dog dog;

 //Constructors and other code
}

class Dog {
 @Expose
 public String name;
 @ManyToOne(fetch=FetchType.Eager)
 public Person owner;

 //Constructor and other code
}


/**************Controller********************/

public class Application extends Controller {

 public static Gson gson = GsonBuilder.excludeFieldsWithoutExposeAnnotation().create;

 public static void allPersons() {
  List<Person> people = Person.findAll();
  renderJSON(gson.toJson(people));

 //Error should be taken care of
 }
}