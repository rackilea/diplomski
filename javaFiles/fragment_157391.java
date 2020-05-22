boolean doesContainAll = true;
HashSet<String> valuesFromArray = new HashSet<>(Arrays.asList(options));
for (String value : abc.values()) {
    if (!valuesFromArray.contains(value)) {
        doesContainAll = false;
        break;
    }
}

// doesContainAll now is correctly set to 'true' or 'false'