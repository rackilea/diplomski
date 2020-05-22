sealed public class IdLockTrans
{
    [SpaceID]
    [SpaceRouting]
    public string ID
    {
        get;
        set;
    }

    [DataMember]
    public bool Unlocked
    {
        get;
        set;
    }

    public IdLockTrans(Id id)
    {
        ID = id.ID;
    }

    public IdLockTrans()
    {
    }
}