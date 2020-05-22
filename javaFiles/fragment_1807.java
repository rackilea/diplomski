List<String> getSubjectNames(Town town) {
    if (town == null) {
        return Collections.emptyList();
    }

    return town.getSchool()
               .getSubjects()
               .stream()
               .map(Subject::getName)
               .collect(Collectors.toList());
}