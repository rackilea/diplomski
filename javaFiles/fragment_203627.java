class person implements Comparable<person>
{
int id;
String name;
@Override
public int compareTo(person o) {
  return this.name.compareTo(o.name);
}
};