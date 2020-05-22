public abstract class Member {

    private int remainingCredit;
    // Other members
    // getters and setters

    protected Member(String memId, String memName, int remainingCredit) {
        this.memId = memId;
        this.memName = memName;
        this.remainingCredit = remainingCredit;
    }
}

public StandardMember extends Member {

    public StandardMember(String memId, String memName) {
        super(memId, memName, 30);
    }
}

public PremiumMember extends Member {

    public PremiumMember(String memId, String memName) {
        super(memId, memName, 45);
    }
}