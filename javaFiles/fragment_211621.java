Map<Integer, List<Permission>> rpMap = roles.stream()
        // filter based on accessCode logic itself
        .filter(accessCode -> !loginAccessCodes.contains(accessCode.getAcCodeId()))
        // set the parameters within function called inside 'map'
        .map(accessCode -> getRolePermissionsWithFlagsSet(accessCode.getAcCodeId()))
        .flatMap(Collection::stream) // flat it to Stream<Permission>
        .collect(Collectors.groupingBy(Permission::getPermId)); // group it using the 'id' (Integer)