Set<String> ids = new HashSet<String>(ListA.size());
for(Talent checkedTalent : ListA) {
    ids.add(checkedTalent.Id);
}
for(Talent filteredTalent : ListB) {
    if (ids.contains(filteredTalent.Id)) {
        filteredTalent.isSelected = true;
    }
}