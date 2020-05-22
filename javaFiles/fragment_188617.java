public SortedMap<String, Long> skill_nApplicants() {
    return skillMap.values().stream().collect(Collectors.toMap(
            Skill::getName,
            Skill::getNumApplicants,
            Math::addExact, // only called if duplicate names can occur
            TreeMap::new
    ));
}