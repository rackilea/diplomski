public class ClassWithCompositeKeyMap : ClassMap<ClassWithCompositeKey>
{
    public ClassWithCompositeKeyMap()
    {
        CompositeId()
            .KeyProperty(x => x.Id1)
            .KeyProperty(x => x.Id2);

        Map(x => x.Type);

        Map(x => id1).Column("Id1").Access.Using("field").ReadOnly();

        HasMany(x => x.Children)
            .Where("Type = 'S'")
            .PropertyRef("id1")
            .KeyColumns.Add("Id2")
            .Inverse();
    }

    public virtual int id1 { get; set; }
}