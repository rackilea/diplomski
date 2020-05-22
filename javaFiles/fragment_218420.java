public static List<DrugInventory> findMissingDrugs(List<Drug> drugs, 
                                                   List<DrugInventory> inventory) {
    Set<String> drugIdLookup = drugs.stream()
                                    .map(d -> d.id)
                                    .collect(Collectors.toCollection(HashSet::new));
    return inventory.stream()
                    .filter(i->!drugIdLookup.contains(i.inventoryId))
                    .collect(Collectors.toList());      
}