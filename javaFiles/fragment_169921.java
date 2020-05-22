private void enrichSite(Collection<Site> sites) {
    sites.forEach(site ->
        site.setTags(tagMapping.stream().filter(x -> x.getSiteId().equals(site.getId()))
            .map(mapping -> this.tags.stream().filter(x -> x.getId().equals(mapping.getTagId())).findFirst().get())
            .collect(Collectors.toSet())));
}