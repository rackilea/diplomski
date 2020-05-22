public class Employee
{
    public static final Comparator<Employee> BY_ID_COMPARATOR
        = new ByIdComparator();

    private static final class ByIdComparator : Comparator<Employee>
    {
        ...
    }
}