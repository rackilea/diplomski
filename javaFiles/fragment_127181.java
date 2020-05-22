TagManager tagManager = resourceResolver.adaptTo(TagManager.class);
Asset asset = resource.adaptTo(Asset.class);
Object[] tags = asset.getMetaData("cq:tags");

for (Object obj : tags) {
     Tag tag = tagManager.resolve(obj.toString());
    //Do something with your tag.
}