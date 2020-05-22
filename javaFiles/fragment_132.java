public void onModuleLoad() {
    FormPanel formPanel = new FormPanel();
    formPanel.setWidth("500px");
    formPanel.setHeight("650px");

    RootPanel.get().add(formPanel);

    MapOptions options = MapOptions.create();

    options.setZoom(6);
    options.setMapTypeId(MapTypeId.ROADMAP);
    options.setDraggable(true);
    options.setMapTypeControl(true);
    options.setScaleControl(true);
    options.setScrollwheel(true);

    GoogleMap gMap = GoogleMap.create(formPanel.getElement(), options);

    gMap.setCenter(LatLng.create(58.378679, -2.197266));
}