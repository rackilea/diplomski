final ExampleServiceAsync exampleInstance = GWT.create(ExampleService.class);

    @UiField
    Button fooButton;
    @UiField
    VerticalPanel fooPanel;
    @UiField
    Image fooImage;

    public Example() {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @UiHandler("fooButton")
    public void onSubmit(ClickEvent clickEvent) {

    mainInstance.getFoo(new AsyncCallback<String>() {

        @Override
        public void onSuccess(String foo) {
            fooImage.setUrl("data:image/png;base64," + foo);
            fooImage.getElement().getStyle()
                    .setVisibility(Visibility.HIDDEN);
        }

        @Override
        public void onFailure(Throwable caught) {
            Window.alert(caught.getMessage());
        }
      });
    }

    @UiHandler("fooImage")
    public void onLoad(LoadEvent event) {
          fooImage.setPixelSize(304,
            fooImage.getHeight() * 304 / fooImage.getWidth());
          fooImage.getElement().getStyle().setVisibility(Visibility.VISIBLE);
    }