@Table(name = "t4", keyspace = "test")
public class Test4Data {
    @PartitionKey
    int id;

    @ClusteringColumn
    @Column(name = "c")
    int clCol;

    @Column(name = "t")
    String text;
// ... getters/setters, etc.
}

MappingManager manager = new MappingManager(session);
Mapper<Test4Data> mapper = manager.mapper(Test4Data.class);
Test4Data test4Data = mapper.get(0, 1);
// output as JSON, etc.