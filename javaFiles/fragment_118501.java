abstract class SuperClass
{
    public abstract void CreateDatabaseTables();
}

class SubClassA extends SuperClass
{
    public void CreateDatabaseTables() { /*do whatever*/ }
}
class SubClassB extends SuperClass
{
    public void CreateDatabaseTables() { /*do whatever else*/ }
}