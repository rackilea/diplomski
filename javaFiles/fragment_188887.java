oldList.replaceAll(old -> 
    updateListe.stream()
        .filter(updated -> updated.getId().equals(old.getId())
        .findFirst()
        .orElse(old)
);