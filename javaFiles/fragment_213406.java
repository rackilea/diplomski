@GET
@Produces(MediaType.TEXT_HTML)
public IndexView index() throws IOException {

    // Get events json data from Events microservice
    ApiResponse events = getEventsJsonData();

    // Render the Events component and pass in props
    @SuppressWarnings("unchecked")
    List<Object> eventsProps = (List<Object>) events.getList();
    String eventsComponent = this.nashornController.renderReactJsComponent(kEventsUiComponentRenderServerFunction, eventsProps);

    IndexView index = new IndexView(eventsComponent);
    return index;
}