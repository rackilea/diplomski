@Embedded
@AttributeOverrides({
        @AttributeOverride(name="lat", column=@Column(name="LAT_COLUMN_XXX")),
        @AttributeOverride(name="lng", column=@Column(name="LNG_COLUMN_YYY"))
})
private LatLng lat;