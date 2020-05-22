public class Record
{
    @SerializedName("Records")
    private List<Object> recordsList;

    public Record()
    {
        this. recordsList = new ArrayList<>();
    }

    public List<Object> getRecordsList()
    {
        return recordsList;
    }
}