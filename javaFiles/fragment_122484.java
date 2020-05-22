public class Group<T extends GroupMember>{
    protected boolean special = false;
    private List<T> members;
}

public class SpecialGroup extends Group<SpecialMember>{
     public SpecialGroup() {
         special = true;
}

public class GroupMember{

    private Group<? extends GroupMember> group;
}

public class SpecialGroupMember extends GroupMember{
    private boolean something;
}