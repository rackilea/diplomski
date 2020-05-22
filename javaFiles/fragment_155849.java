Map<String, OrganismeDTO> map = dt.stream().collect(HashMap::new, (m, t) -> {
    m.computeIfAbsent(t.getOrganismeLib(), x -> new OrganismeDTO(t.getOrganismeLib())).getRolesDTO().add(new RoleDTO(t.getRoleLib()));
}, (m1, m2) -> {
    m2.forEach((k,v) -> {
        OrganismeDTO organismeDTO = m1.get(k);
        if (organismeDTO != null ) {
            organismeDTO.getRolesDTO().addAll(v.getRolesDTO());
        } else {
            m1.put(k, v);
        }
    });
});