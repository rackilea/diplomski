public void loopThrough(List<Region> regions) {
    for(Region region : regions) {
        if(region.hasSubRegion()) { 
            loopThrough(region.getSubRegions());
        }
    }
}