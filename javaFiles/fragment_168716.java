public class DocData
{
    private String text;

    private List<Entity> entities;

    public DocData(final String text, final List<Entity> entities)
    {
        this.text = text;
        this.entities = entities;
    }

    public List<Entity> getEntities()
    {
        return entities;
    }
}


public class Entity
{
    private String field_name_1;

    private String field_name_2;

    private List<List<Integer>> field_name_3;
}