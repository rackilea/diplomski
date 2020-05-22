public class ClassWithCompositeKey
{
    private int id1;
    private int id2;

    public ClassWithCompositeKey()
    {
        Children = new List<ClassWithCompositeKey>();
    }

    public virtual int Id1
    {
        get { return id1; }
        set { id1 = value; }
    }
    public virtual int Id2
    {
        get { return id2; }
        set { id2 = value; }
    }

    public virtual string Type { get; set; }

    public virtual ICollection<ClassWithCompositeKey> Children { get; protected set; }

    public override bool Equals(object obj)
    {
        var other = obj as ClassWithCompositeKey;
        return other != null && Id1 == other.Id1 && Id2 == other.Id2;
    }

    public override int GetHashCode()
    {
        return (Id1 << 16) | Id2;  // optimized for Id's < 16 bit
    }
}