@Entity
class Car
{
 private int Id;
 private String name;
 //.......... declare all  variables that you need
 @OneToMany(mappedBy = "car")
 private List<Translation>
 //getters and setters
 }

@Entity
class City
{
 private int Id;
 private String name;
 //.......... declare all  variables that you need
 @OneToMany(mappedBy = "city")
 private List<Translation>
 //getters and setters
 }   

@Entity
class Translation
{
 private int Id;
 private String language;
 //.......... declare all  variables that you need
 @ManyToOne
 private Car;
 @ManyToOne
 private City;
 //getters and setters
 }