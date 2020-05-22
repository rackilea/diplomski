Set<PVector> uniques = new HashSet<>();
Set<PVector> duplicates = new HashSet<>();
for (PVector p : listToCull) {
    if (!duplicates.contains(p)) {
        if (uniques.contains(p)) {
            uniques.remove(p);
            duplicates.add(p);
        }
        else {
            uniques.add(p);
        }
    }
}