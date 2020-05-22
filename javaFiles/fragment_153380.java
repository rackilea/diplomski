public class Pc {
    @DatabaseField(generatedId = true)
    private long id;
    @ForeignCollectionField
    private ForeignCollection<PcEthernet> pcEthernets;
    ...
}