public enum BuildingTechTree {
    // Named constants
    //Name                      SoftName                        Requirements
    NONE                        ("NULL",                        null),
    BARRACKS                    ("Barracks",                    setOf(NONE)),
    WALLS_SANDBAGS              ("Sandbag wall",                setOf(NONE)),
    POWERPLANT                  ("Power plant",                 setOf(BARRACKS)),
    GUARDTOWER                  ("Guard Tower",                 setOf(BARRACKS));

    private final String softName;
    private Set<BuildingTechTree> requirements;

    private BuildingTechTree(String softName, Set<BuildingTechTree> requirements) {
        this.softName = softName;
        this.requirements = requirements;
    }

    private static Set<BuildingTechTree> setOf(BuildingTechTree... values) {
        return new HashSet<>(Arrays.asList(values));
    }

    static {
        for (BuildingTechTree v : values()) {
            if (v.requirements == null) {
                v.requirements = EnumSet.noneOf(BuildingTechTree.class);
            } else {
                v.requirements = EnumSet.copyOf(v.requirements);
            }
        }
    }
}