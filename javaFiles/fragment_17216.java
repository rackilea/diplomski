@Override
public List<CityDefinition> findCitiesNearby(GeoPoint geo, double distance, String source) {
    LOGGER.info("<findCitiesNearby>");

    //FilterBuilder filterBuilderGeo = FilterBuilders.geoDistanceFilter("geo").point(geo.getLat(), geo.getLon()).distance(distance, DistanceUnit.KILOMETERS);

    FilterBuilder filterBuilderGeo = FilterBuilders.geoDistanceFilter("geo").point(geo.getLat(), geo.getLon());

    SearchQuery q = new NativeSearchQueryBuilder()
            .withFilter(filterBuilderGeo);

    List<?> fields = esOps.queryForList(q, CityDefinition.class);

    return (List<CityDefinition>) fields;
}