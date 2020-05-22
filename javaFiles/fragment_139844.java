import static org.fest.reflect.core.Reflection.*;

// Retrieves the value of the field "name"
String name = field("name").ofType(String.class).in(person).get();

// Retrieves the value of the field "powers"
List<String> powers = field("powers").ofType(new TypeRef<List<String>>() {})
                                     .in(jedi).get();

// Retrieves the value of the static field "count" in Person.class
int count = field("count").ofType(int.class).in(Person.class).get();


// Retrieves the value of the static field "commonPowers" in Jedi.class
List<String> commmonPowers = field("commonPowers")
                                    .ofType(new TypeRef<List<String>>() {})
                                    .in(Jedi.class).get();