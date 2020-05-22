class item {
    String link;
}
@JsonIgnoreProperties(ignoreUnknown=true)
class Result {
    item[] items;
}