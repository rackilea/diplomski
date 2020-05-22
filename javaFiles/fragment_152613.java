public void handelSomeUiThing()
{
    SqlController sc = new SqlController();
    sc.openConnection();
    YourData = sc.getSomeData();
    sc.closeConnection();
}