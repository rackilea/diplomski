@And("^some test step$")
public void someTestStep(DataTable table)
{
    List<List<String>> data = table.asLists(String.class);
    String buildingName = data.get(1).get(1);
    String reference = data.get(2).get(1);
}