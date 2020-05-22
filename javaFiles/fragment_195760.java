VersionIterator iterator = ocm.getAllVersions(path);

while (iterator.hasNext()) {
    Version version = (Version)iterator.next();

    //Here you go:
    MarketingZone m1 = (MarketingZone) version.getFrozenNode();

    System.out.println(m1.getName());

}