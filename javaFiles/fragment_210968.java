static List<MandantLinkCheckerEntry> createMandantLinkCheckerEntries(Struct struct) {
    Map<String, Object> linkCheckerMandants = struct.toNestedMaps();
    return linkCheckerMandants.values().parallelStream()
            .map(Map.class::cast)
            .map((Function<Map,MandantLinkCheckerEntry>)MandantLinkCheckerEntry::convertMapToMandantCheckerEntry)
            .collect(Collectors.toList());
}