modelMapper.addMappings(new PropertyMap() {
    @Override
    protected void configure() {
        using(new LocationConverter()).map().setLocation(source.getLocationList());
    }
});