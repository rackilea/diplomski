List<Version> versions = new ArrayList<Version>();
    Version version = new Version();
    version.setVersionName("Test");
    version.setNumber("1");
    versions.add(version);

    PutBody putBody = new PutBody();

    putBody.setName("TEST CES LIST4");
    putBody.setId("89960004");
    putBody.setVersions(versions);