public class StaticInitialization{
    // table1 is initialized when the class StaticInitialization is loaded
    static Table table1 = new Table();

    // table2 is initialized when a new instance of StaticInitialization is created
    Table table2 = new Table();

    ...
}