@Table(keyspace="testks", name="DataSet", caseSensitiveKeyspace=false, caseSensitiveTable=false)
public class DataSet {

@PartitionKey
@Column
String id;
@Column
String name;

public Dataset() {
}

public String getName() {
    return name;
}

public DataSet setName(String name) {
    this.name = name;
    return this;
}

public DataSet setId(String id){
    this.id = id;
    return this;
}

public DataSet(String name){
    this.id = UUIDs.timeBased().toString();
    this.name = name;
}
}