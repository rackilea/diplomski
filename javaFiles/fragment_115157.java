Set<Long> empIdsSet = new HashSet<Long>(empIds);
for (Long id : ids) {
    if (empIdsSet.contains(id)) {
        checker = true;
        break;
    }
}