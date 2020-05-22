import com.persistit.*;
import com.persistit.exception.*;
import java.io.*;
import java.util.*;

public class IndexDemo implements AutoCloseable
{
  public static class User implements Serializable
  {
    public int id;
    public String firstName;
    public String lastName;

    public User() {
    }

    public User(int id, String firstName, String lastName) {
      this.id = id;
      this.firstName = firstName;
      this.lastName = lastName;
    }

    @Override
    public String toString() {
      return String.format("User(%d, %s, %s)", id, firstName, lastName);
    }
  }

  private final Persistit db;

  public IndexDemo() throws PersistitException {
    Configuration c = new Configuration();
    c.getBufferPoolMap().get(16384).setCount(32);
    c.getVolumeList().add(new VolumeSpecification(
      "IndexDemo.vol,create,pageSize:16384,initialPages:5,extensionPages:5,maximumPages:100"
    ));
    this.db = new Persistit(c);
  }

  @Override
  public void close() throws PersistitException {
    db.close();
  }

  public Exchange userEx() throws PersistitException {
    return db.getExchange("IndexDemo", "users", true);
  }

  public Exchange firstNamesEx() throws PersistitException {
    return db.getExchange("IndexDemo", "firstNames", true);
  }

  // Save the user, both primary and secondary firstName index
  public void saveUser(User u) throws PersistitException {
    Exchange ex = userEx();
    // Primary entries: key of ID and value of full User
    ex.getKey().append(u.id);
    ex.getValue().put(u);
    ex.store();
    // First name index: key of (name,ID)
    ex = firstNamesEx();
    ex.append(u.firstName).append(u.id);
    ex.store();
  }

  // Look-up the user by ID
  public User userByID(int id) throws PersistitException {
    Exchange ex = userEx();
    // Construct and fetch our key
    ex.getKey().append(id);
    ex.fetch();
    // Careful: may not exist
    if(!ex.getValue().isDefined()) {
        return null;
    }
    // Otherwise get it from the value
    return (User)ex.getValue().get();
  }

  // Index scan for users with firstName, look-up and return all matches
  public List<User> usersByFirstName(String firstName) throws PersistitException {
    List<User> users = new ArrayList<>();
    Exchange ex = firstNamesEx();
    // Iterate over only entires matching firstName
    ex.append(firstName).append(Key.BEFORE);
    while(ex.next()) {
      // Index to second component (id) and decode
      int id = ex.getKey().indexTo(1).decodeInt();
      // And lookup the user
      users.add(userByID(id));
    }
    return users;
  }

  public static void main(String[] args) throws PersistitException {
    try(final IndexDemo demo = new IndexDemo()) {
      System.out.println("No Transaction:");
      runDemo(demo);
    }
    try(final IndexDemo demo = new IndexDemo()) {
      System.out.println("Transaction:");
      demo.db.getTransaction().run(new TransactionRunnable() {
        @Override
        public void runTransaction() throws PersistitException {
          runDemo(demo);
        }
      });
    }
  }

  public static void runDemo(IndexDemo demo) throws PersistitException {
    demo.saveUser(new User(1, "John", "Doe"));
    demo.saveUser(new User(2, "John", "Smith"));
    demo.saveUser(new User(3, "Sally", "Jones"));
    System.out.println("  User  1: " + demo.userByID(1));
    System.out.println("  User 10: " + demo.userByID(10));
    System.out.println("  Users named John:");
    for(User u : demo.usersByFirstName("John")) {
      System.out.println("    " + u);
    }
  }
}