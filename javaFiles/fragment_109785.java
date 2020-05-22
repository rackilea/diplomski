class Equipment {
    private String name;
    private String description;
    ...
    @SerializedName("game_types")
    private List<String> gameTypes;
    ...
    private Details details;
    ...
}
class Details {
    ...
    @SerializedName("infix_upgrade")
    private InfixUpgrade infixUpgrade;
    ...
}
class InfixUpgrade {
    private List<Attribute> attributes; 
    ...
}
class Attribute {
    private String attribute;
    private int modifier;
    ...
}