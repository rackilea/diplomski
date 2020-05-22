Map<Integer, List<Permission>> rpMap = roles.stream()
        .map(accessCode -> getRolePermissions(accessCode.getAcCodeId()))
        .flatMap(Collection::stream)
        .filter(permission -> !loginAccessCodes.contains(permission.getPermId()))
        // following is what fails the purpose of using streams here
        .map(permission -> {
            permission.setChecked(false);
            permission.setGrayed(true);
            return permission;
        })
        .collect(Collectors.groupingBy(Permission::getPermId));