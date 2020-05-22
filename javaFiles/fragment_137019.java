List<String> aoGuidList = new ArrayList<>();
it.getParts().forEach(itt -> {
    aoGuidList.add("\"" + itt.getAoGuid() + "\"");
});

queryHouseService.search(aoGuidList);