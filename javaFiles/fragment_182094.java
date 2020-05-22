// Creating a graph to help hibernate to create a query with outer join.
@NamedEntityGraph(name="graph.Person.friends",
    attributeNodes = @NamedAttributeNode(value = "friends"))
class Person {}

interface PersonRepository extends JpaRepository<Person, Long> {
    // using the named graph, it will fetch all friends in same query
    @Override
    @EntityGraph(value="graph.Person.friends")
    Person findOne(Long id);
}

@Override
public Person addFriend(String personName, String friendName) 
    throws FriendshipExistsException, PersonNotFoundException {
    Person person = retrieveWithName(personName);
    Person friend = retrieveWithName(friendName);
    if(!person.getFriends().contains(friend)){
        person.getFriends().add(friend);
        friend.getFriends().add(person); // need to setup the relation
        return repository.save(person); // only one save method is used, it saves friends with cascade
    } else {
        throw new FriendshipExistsException(personName, friendName);
    }