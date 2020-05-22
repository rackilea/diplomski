public interface ChangeViewListener {
    void onViewChanged();
}

private ChangeViewListener listener;


public void setAlert(String message) {
    alertDialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE);
    alertDialog.setTitleText("Error");
    alertDialog.setContentText(message);
    alertDialog.setConfirmText("Aceptar");
    alertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
        @Override
        public void onClick(SweetAlertDialog sweetAlertDialog) {

            if(listener != null) {
               listener.onViewChanged();
            }


        }
    });
    alertDialog.show();
}

public void setListener(ChangeViewListener listener) {
   this.listener = listener;
}