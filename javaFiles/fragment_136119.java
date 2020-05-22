public class Emp {
  private int id;
  private int salary;
  private int name;

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Emp)) {
      return false;
    }

    final Emp emp = (Emp) o;

    if (id != emp.id) {
      return false;
    }
    if (name != emp.name) {
      return false;
    }
    if (salary != emp.salary) {
      return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + salary;
    result = 31 * result + name;
    return result;
  }
}