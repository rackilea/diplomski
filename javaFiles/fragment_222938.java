@Environmental
private Heartbeat heartbeat;

@SetupRender
void setupRender(MarkupWriter writer) {
    writer.element("div");
}

// let the body render as normal

@AfterRender
void afterRender(final MarkupWriter writer) {
    Element wrapper = writer.element();
    writer.end();
    final String bodyMarkup = wrapper.getChildMarkup();

    // remove the body 
    wrapper.remove();

    heartbeat.defer(new Runnable() {
        public void run() {
            Element pageBody = writer.getDocument().find("html/body");
            pageBody.raw(bodyMarkup);
        }
    });
}