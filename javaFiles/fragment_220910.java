private Map<Long, String> themaIdsAndLabels = new HashMap<Long, String>();

// ...

public void submit() {
    String themaLabel = themaIdsAndLabels.get(thema);
    // ...
}