Map<String, Set<Attribute>> applicableAttributeMap = new HashMap<>();

    List<String> givenNames = ImmutableList.copyOf(....);

    Set<Attribute> unionMandatoryAttributes =   
             givenNames.stream()
                       .map(this::getAllApplicableAttributes)
                       .flatMap(Collection::stream)
                       .filter(Attribute::getIsRequired)
                       .collect(Collectors.toSet());

    Set<Attribute> intersectedAttributes = ImmutableSet.of();
    if (givenNames.size() > 0) {
        intersectedAttributes = this.getAllApplicableAttributes(givesNames.get(0));         
        for (int i = 1; i < givenNames.size(); i++) {
             intersectedAttributes = Sets.intersection(intersectedAttributes, getAllApplicableAttributes(givesNames.get(i)));                           
        }
    }

    applicableAttributeMap.put("UnionMandatory", unionMandatoryAttributes);
    applicableAttributeMap.put("IntersectedAll", intersectedAttributes);
}