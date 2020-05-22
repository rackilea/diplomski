public class PasswordStrengthWidget extends Composite {

    private static class PasswordStrength extends JavaScriptObject {

        protected PasswordStrength() {}

        public final native String getRating() /*-{
            return this.rating;
        }-*/;
    }

    private static final String RATING_URL = URL.encode("https://www.google.com/accounts/RatePassword?Passwd=");
    private static final String[] STRENGTH = {"very weak", "weak", "medium", "strong"};
    @UiField
    Label indicator;
    private PasswordTextBox fPassword;

    ...

    private void updateStrengthIndicator() {
        JsonpRequestBuilder request = new JsonpRequestBuilder();
        request.requestObject(RATING_URL + fPassword.getText(), new AsyncCallback<PasswordStrength>() {

            @Override
            public void onSuccess(PasswordStrength result) {
                indicator.setText(STRENGTH[Integer.parseInt(result.getRating()) - 1] + result.getRating());
            }

            @Override
            public void onFailure(Throwable caught) {
                indicator.setText("error calculating strength");
            }
        });
    }
}