@PageActivationContext(index=0)
private String filterSetJson;

@PageActivationContext(index=1)
private Integer pageCount;

void setupRender() {
    if (pageCount == null) {
        ...
    } else {
        ...
    }
}