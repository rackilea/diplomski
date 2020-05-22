class Tag {
    private int id;
    // ...
    static Tag useless() {
        return new Tag(-1);
    }
}


private void enrichSite(Collection<Site> sites) {
    sites.forEach(site ->
        site.setTags(tagMapping.stream().filter(x -> x.getSiteId().equals(site.getId()))
            .map(mapping -> this.tags.stream().filter(x -> x.getId().equals(mapping.getTagId())).findFirst().orElseGet(Tag::useless))
            .filter(tag -> tag.getId() != -1)
            .collect(Collectors.toSet())));
}