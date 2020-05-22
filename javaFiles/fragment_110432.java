public class LoginFormB extends Composite {

  private static LoginFormBUiBinder uiBinder = GWT.create(LoginFormBUiBinder.class);

  interface LoginFormBUiBinder extends UiBinder<Widget, LoginFormB> {}

  @UiField
  FormPanel formPanel;

  public LoginFormB() {
    formPanel.addSubmitCompleteHandler(new SubmitCompleteHandler() {

        @Override
        public void onSubmitComplete(SubmitCompleteEvent arg0) {
            // Redirect to needed page
            redirect("needed url");
        }
    });
    initWidget(uiBinder.createAndBindUi(this));
  }

  public static native void redirect(String url)/*-{
    $wnd.location = url;
  }-*/;
}