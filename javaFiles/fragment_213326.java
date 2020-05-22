public UserAppData(@JsonProperty("boughtAppIDs") int[] boughtAppIDs, @JsonProperty("boughtAppPacks") UserPackData[] boughtAppPacks) {
    this.boughtAppIDs = boughtAppIDs;
    this.boughtAppPacks = boughtAppPacks;
}
...
public UserPackData(@JsonProperty("id") int id, @JsonProperty("gold") boolean gold) {
    this.id = id;
    this.gold = gold;
}