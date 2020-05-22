static List<MandantLinkCheckerEntry> createMandantLinkCheckerEntries(Struct struct) {
    Map<String, Map<String, Object>> linkCheckerMandants = struct.toNestedMaps();
    return linkCheckerMandants.values().parallelStream()
            .map(MandantLinkCheckerEntry::convertMapToMandantCheckerEntry)
            .collect(Collectors.toList());
}