public interface Item {
    String getName();
    ...
}

public interface ItemDAO {
    Item lookup(String name);
    ...
}

@NodeEntity
public class ItemNode implements Item {
    @GraphId private Long id;
    private String name;
    ...
    public String getName() { return name; }
    ...
}

public class Neo4jItemDAO implements ItemDAO {
    ...
    @Override
    public Item lookup(String name) {
        return neo4jOperations.lookup(ItemNode.class,"name", name).to(ItemNode.class).singleOrNull();
    }
}