ProList minFilteredRow;
if (proLists.stream().anyMatch(a -> a.getProEffectiveDate() == null)) {
    minFilteredRow = proLists.get(0);
} else {
    minFilteredRow = proLists.stream()
            .filter(filteredRow)
            .min(Comparator.comparing(ProList::getRecordNumber))
            .orElse(null);
}