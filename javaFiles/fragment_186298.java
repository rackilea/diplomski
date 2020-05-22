List<String> goodNames = new ArrayList<>();
for (String name : personalNames) {
    if (!isErrorProne(name)) {
        goodNames.add(name);
    }
}