class CategoryItem
{
    int id;
    String name;

    // add other fields if you want...

    CategoryItem(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
    String toString()
    {
        return name;
    }
}