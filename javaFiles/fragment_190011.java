public static final List<String> listPersons = new ArrayList<>();

//...

public void initialize() {
    List<String> contents = populateContentsFromEnvironmentVariable();
    listPersons.addAll(contents);
}