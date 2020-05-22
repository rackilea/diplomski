static class Person
{
   String name;
   int age;
   public Person(String name, int age)
   {
      this.name = name;
      this.age = age;
   }
   public String toString()
   {
      return name + " " + age;
   }
   public int hashCode()
   {
      int ha = 31;
      ha = 31 * ha + ((Integer) age).hashCode();
      ha = 31 * ha + (null == name ? 0 : name.hashCode());
      return ha;
   }
   public boolean equals(Object o)
   {
      if (this == o)
         return true;
      if ((o == null) || (o.getClass() != this.getClass()))
         return false;
      final Person t = (Person) o;
      return age == t.age && null != name ? name.equals(t.name) : null == t.name;
   }
}

// Map of persons and their friends.
private static final Map<Person,Set<Person>> map = new HashMap<>();

// Adds a person, without any friends, if not already added.
public void addPerson(Person p)
{
   if (DEBUG)
   {
      StdOut.format("P %s\n", p);
   }
   if (!map.containsKey(p))
   {
      map.put(p, new HashSet<Person>());
   }
}

// Adds two persons to each others "friends' list".
// addFriendship does nothing if p1 and p2 are already friends or if one
// does not exist
public void addFriendship(Person p1, Person p2)
{
   if (DEBUG)
   {
      StdOut.format("F %s %s\n", p1, p2);
   }
   if (!p1.equals(p2) && map.containsKey(p1) && map.containsKey(p2))
   {
      map.get(p1).add(p2);
      map.get(p2).add(p1);
   }
}

// Removes persons from each others "friends' list".
// removeFriendship does nothing if p1 and p2 are not friends or if one does
// not exist
public void removeFriendship(Person p1, Person p2)
{
   if (DEBUG)
   {
      StdOut.format("U %s %s\n", p1, p2);
   }
   if (!p1.equals(p2) && map.containsKey(p1) && map.containsKey(p2))
   {
      map.get(p1).remove(p2);
      map.get(p2).remove(p1);
   }
}

// Checks whether two persons are mutually friends.
// queryFriendship returns false if p1 and p2 are not friends or if one does
// not exist
public boolean queryFriendship(Person p1, Person p2)
{
   if (DEBUG)
   {
      StdOut.format("Q %s %s\n", p1, p2);
   }
   final Set<Person> s1 = map.get(p1);
   final Set<Person> s2 = map.get(p2);
   return null != s1 && null != s2 && s1.contains(p2) && s2.contains(p1);
}

// Lists a person's friends, if any.
// lookupFriends returns null or empty iterable if p does not exists
public Iterable<Person> lookupFriends(Person p)
{
   if (DEBUG)
   {
      StdOut.format("L %s\n", p);
   }
   return map.get(p);
}