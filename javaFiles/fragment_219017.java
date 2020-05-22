public static void main(String[] args) {

    List<String> StringListOne = new ArrayList<>();
    // add values
    List<String> StringListTwo = new ArrayList<>();
    // add values

    List<ListMetadata> metadataList = new ArrayList<>();
    metadataList.add(new ListMetadata("StringListOne", StringListOne));
    metadataList.add(new ListMetadata("StringListTwo", StringListTwo));

    // get first list name
    String firstListName = metadataList.get(0).getName();

    // get list of all names
    List<String> names = metadataList.stream().map(ListMetadata::getName).collect(Collectors.toList());
}

static class ListMetadata {
    String name;
    List<String> value;

    public ListMetadata(String name, List<String> value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public List<String> getValue() {
        return value;
    }
}