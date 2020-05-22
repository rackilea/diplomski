@Entity(indices = {@Index(value = {"battery", "code"}, unique = true)})
public class BirdsRoom {

@PrimaryKey(autoGenerate = true)
private int id;

@ColumnInfo(name = "battery")
private String battery;

@ColumnInfo(name = "code")
private String birdCode;

@ColumnInfo(name = "latitude")
private double lat;

@ColumnInfo(name = "longitude")
private double lng;