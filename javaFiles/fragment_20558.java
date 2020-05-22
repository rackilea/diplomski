private DetachedCriteria clipOwnerWithName(String searchedName, String aliasOfFolder) {
    DetachedCriteria c = DetachedCriteria.forClass(Folder.class, "clipFolder");
    c.createAlias("clipFolder.clips", "clip");
    c.createAlias("clip.owner", "owner");
    c.add(Restrictions.propertyEq("clipFolder.id", aliasOfFolder + ".id");
    c.add(Restrictions.like("owner.name", searchedName);
    c.setProjection(Projections.property("clip.id"));
}