public enum Example {

    ENUM_A1 (Group.A),
    ENUM_A2 (Group.A),
    ENUM_A3 (Group.A),

    ENUM_B1 (Group.B),
    ENUM_B2 (Group.B),
    ENUM_B3 (Group.B),

    ENUM_C1 (Group.C),
    ENUM_C2 (Group.C),
    ENUM_C3 (Group.C);

    private Group group;

    Example(Group group) {
        this.group = group;
    }

    public boolean isInGroup(Group group) {
        return this.group == group;
    }

    public enum Group {
        A,
        B,
        C;
    }
}