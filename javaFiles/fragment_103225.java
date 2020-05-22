KeyFinder(int key, String keyName, String... lookupKeys) {
    this.key = key;
    this.keyName = keyName;
    this.lookupKeys.add(keyName);
    this.lookupKeys.addAll(Arrays.asList(lookupKeys));
}