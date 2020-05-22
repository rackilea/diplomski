Set<String> exclusions = excludingDepartmentList.stream()
    .map(PresentationDetails::getDepartmentNumber)
    .collect(Collectors.toSet());
List<Presentation> filtered = presentedDepartmentList.stream()
    .filter(p -> !exclusions.contains(p.getDepartmentNumber()))
    .collect(Collectors.toList());