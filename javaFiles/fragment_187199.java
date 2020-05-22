public enum Type {
    CAPTAIN(2),
    LEADER(5),
    PARTIER(80);

    private final int morale;

    private Type(int m){
        morale = m;
    }

    public int getMorale(int inMorale) {
         return getMorale (inMorale, 0);
    }

    public int getMorale(int inMorale, int teamCount) {
        switch (this) {
            case CAPTAIN:       
            case LEADER:
                return inMorale * (100 + morale) / 100;
            case PARTIER:
                return inMorale + morale * teamCount;
        }
        return 0;
    }
}