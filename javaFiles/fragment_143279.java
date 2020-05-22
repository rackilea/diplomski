public class Person
{
    private String FirstName;
    private String LastName;
    private String Age;
    private List<FavoriteColors> AllColors = new ArrayList<FavoriteColors>();

    public Person(String _firstName, String _lastName, String _age, List<FavoriteColors> _allColors)
    {
        this.FirstName = _firstName;
        this.LastName = _lastName;
        this.Age = _age;
        for (int i = 0; i < _allColors.size(); i++)
        {
            this.AllColors.add(_allColors.get(i));
        }
    }
}