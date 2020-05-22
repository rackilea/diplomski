interface TheBasics
{
    @SqlUpdate("insert into something (id, name) values (:id, :name)")
    int insert(@BindBean Something something);

    @SqlQuery("select id, name from something where id = :id")
    Something findById(@Bind("id") long id);
}

@Test
public void useTheBasics() throws Exception
{
    TheBasics dao = dbi.onDemand(TheBasics.class);

    dao.insert(new Something(7, "Martin"));

    Something martin = dao.findById(7);
}