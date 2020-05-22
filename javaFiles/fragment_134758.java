Results results = new Results();

    for (OrganisationUnitNameHistory children : children2) {
        OrganisationUnit ou = new OrganisationUnit();
        ou.setId(children.getOrganisationunitCode());
        ou.setText(children.getName());
        results.getResults().add(ou);
    }