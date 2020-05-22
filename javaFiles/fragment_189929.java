public class MyDialogBox extends DialogBox {
    private DialogBoxOpener opener = null;
    private final Button cancelButton = new Button("Cancel");
    private final Button validButton = new Button("Ok");
    private final DateBox myDateBox = new DateBox();

    public MyDialogBox () {
            cancelButton.addClickHandler(new ClickHandler () {
                    @Override
                    public void onClick(final ClickEvent event) {
                            hide();
                            if (opener!=null)
                                    opener.dialogBoxCancelled();
                    }
            });

            validButton.addClickHandler(new ClickHandler () {
                    @Override
                    public void onClick(final ClickEvent event) {
                            hide();
                            if (opener!=null)
                                    opener.dialogBoxValidated(myDateBox.getValue());
                    }
            });
            // TODO : create your DialogBox
    }

    public void showDialogBox (final DialogBoxOpener opener) {
            this.opener = opener;
            // Show the DialogBox
            center ();
    }
}