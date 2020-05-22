import java.util.*;

class BinarySearchWithComparator
{
  public static void main(String[] args)
  {
    // Please scroll down to see 'User' class implementation.
    List<User> l = new ArrayList<User>();
    l.add(new User(10, "A"));
    l.add(new User(20, "B"));
    l.add(new User(30, "C"));

    Comparator<User> c = new Comparator<User>() {
      public int compare(User u1, User u2) {
        return u1.getId().compareTo(u2.getId());
      }
    };

    // Must pass in an object of type 'User' as the key.
    // The key is an 'User' with the 'id' which is been searched for.
    // The 'name' field is not used in the comparison for the binary search,
    // so it can be a dummy value -- here it is omitted with a null.
    //
    // Also note that the List must be sorted before running binarySearch,
    // in this case, the list is already sorted.

    int index = Collections.binarySearch(l, new User(20, null), c);
    System.out.println(index);    // Output: 1

    index = Collections.binarySearch(l, new User(10, null), c);
    System.out.println(index);    // Output: 0

    index = Collections.binarySearch(l, new User(42, null), c);
    System.out.println(index);    // Output: -4
                                  // See javadoc for meaning of return value.
  }
}

class User {
  private int id;
  private String name;

  public User(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return Integer.valueOf(id);
  }
}