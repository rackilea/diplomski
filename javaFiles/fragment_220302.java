private String filter;

private final Timeline timeline = new Timeline(
    new KeyFrame(Duration.millis(100),
                 ae -> setPredicate()
    ));

public void setFilter ( String filter ) {
    if ( filter == null ) filter = "";
    if ( !this.filter.equals( filter ) ) {
        this.filter = filter;
        this.timeline.playFromStart();
    }
}

private void setPredicate() {
    final String filterText = this.filter;

    // The rest remains pretty much the same.
}