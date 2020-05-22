@And("^Then The response fields should be$")
public void thenTheResponseFieldsShouldBe(DataTable table)
{
    List<List<String>> data = table.asLists(String.class);
    String modificationDate = data.get(0).get(0);
    String startDate = data.get(0).get(1);
    String endDate = data.get(0).get(2);
    String id = data.get(0).get(3);
}