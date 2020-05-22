public class DicomEntry
{
private: 
    private string group;
    private string element;
    private string vr;
    private string name;

    public string  key() { return String.format("(%s,%s)",group,element); } 
}