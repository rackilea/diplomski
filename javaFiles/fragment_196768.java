List<BookDto> deskOfficer =  delegationExtendedDto
        .stream()
        .filter(Objects::nonNull)
        .filter(d -> d.getMembers() != null) // stream would handle the empty case
        .flatmap(d -> d.getMembers().stream()) // <<< here -- the stream objects are different
        .filter(Objects::nonNull)
        .filter(m -> RolesEnum.RESPONSIBLE_ADMIN.equals(m.getRole())))
        .collect(Collectors.toList());