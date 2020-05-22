get("/", (request, response) -> {
    if (isTextHtml(request)) {
        // serve the index.html template as is (empty map, not null though)
        // In this case index.html functinos as a static page
    } else {
        // use a map to have all relevant data for the index.html template
        // In this case index.html functinos as a "real" template
    }
});